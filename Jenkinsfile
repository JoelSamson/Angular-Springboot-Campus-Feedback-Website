pipeline {
    environment {
    	DOCKERHUB_CREDENTIALS = credentials('dockid')
	TIMESTAMP = new Date().format("yyyyMMdd_HHmmss")
    }
    agent any
    
    triggers{
        bitbucketPush()
    }

    environment {
        REMOTE_ADDRESS = "REPLACE_WITH_REMOTE_ADDRESS"
    }

    stages {
        stage ('Test & Build Artifact') {
            agent {
                docker {
                    image 'openjdk:17'
                    args '-v "$PWD":/Homework'
                    reuseNode true
                }
            }
            steps {
                sh './gradlew clean build'
            }
        }
        stage ('Build & Push docker image') {
            steps {
               sh "docker build -t ramiyappan/imaagespring:${env.TIMESTAMP} ."
               sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
	       sh "docker push ramiyappan/imaagespring:${env.TIMESTAMP}"
                }
            }
       stage('Update Deployment') {
         steps {
            script{
               sh "kubectl set image deployment/newdeployment newcontainercontainer=ramiyappan/imaagespring:${env.TIMESTAMP}"
            }
         }
      }
      
      stage('Update LoadBalancer') {
         steps {
            script{
               sh 'kubectl rollout restart deploy newdeployment -n default'
            }
         }
      }
   }
}
