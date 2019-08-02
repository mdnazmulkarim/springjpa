package com.nk.springjpa.repository;

import com.nk.springjpa.model.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CitizenRepository extends JpaRepository <Citizen, Long>{

}
