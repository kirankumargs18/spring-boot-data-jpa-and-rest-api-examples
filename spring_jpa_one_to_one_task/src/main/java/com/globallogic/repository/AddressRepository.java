package com.globallogic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globallogic.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
