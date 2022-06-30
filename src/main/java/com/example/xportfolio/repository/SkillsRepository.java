package com.example.xportfolio.repository;

import com.example.xportfolio.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SkillsRepository extends JpaRepository<Skills, String> {
}
