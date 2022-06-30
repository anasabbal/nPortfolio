package com.example.xportfolio;

import com.example.xportfolio.model.*;
import com.example.xportfolio.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableJpaAuditing
public class XPortfolioApplication implements CommandLineRunner{


    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private WriterRepository writerRepository;

    @Autowired
    private SkillsRepository skillsRepository;

    @Autowired
    private AddressRepository addressRepository;

    public static void main(String[] args) {
        SpringApplication.run(XPortfolioApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

    }
}
