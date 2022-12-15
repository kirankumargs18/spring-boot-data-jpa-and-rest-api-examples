package com.globallogic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.entity.Page;

@Repository
public interface PageRepository extends JpaRepository<Page, Long> {

}
