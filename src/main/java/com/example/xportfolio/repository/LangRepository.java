package com.example.xportfolio.repository;

import com.example.xportfolio.model.Lang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LangRepository extends JpaRepository<Lang, String> {
}
