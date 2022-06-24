package com.example.xportfolio.repository;

import com.example.xportfolio.model.About;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AboutRepository extends JpaRepository<About, String> {
}
