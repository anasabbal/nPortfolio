package com.example.xportfolio;

import com.example.xportfolio.model.About;
import com.example.xportfolio.model.Writer;
import com.example.xportfolio.repository.AboutRepository;
import com.example.xportfolio.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class XPortfolioApplication{



    public static void main(String[] args) {
        SpringApplication.run(XPortfolioApplication.class, args);
    }


}
