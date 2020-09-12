package com.albert.consultantManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.albert.consultantManager.model.Consultant;
@Repository
public interface consultantRepository extends JpaRepository<Consultant, Long> {

}
