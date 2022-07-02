package com.example.xportfolio.repository;

import com.example.xportfolio.model.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FormationRepository extends JpaRepository<Formation, String> {
}
