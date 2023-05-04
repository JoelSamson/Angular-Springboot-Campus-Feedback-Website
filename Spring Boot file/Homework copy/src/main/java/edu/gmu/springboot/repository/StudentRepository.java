package edu.gmu.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.gmu.springboot.model.student;

@Repository
public interface StudentRepository extends JpaRepository<student,Long>{
	
}
