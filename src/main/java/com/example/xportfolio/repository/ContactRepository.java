package com.example.xportfolio.repository;

import com.example.xportfolio.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {
}
