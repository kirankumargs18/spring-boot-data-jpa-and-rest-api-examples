package com.globallogic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.entity.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {

}
