package com.globallogic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
