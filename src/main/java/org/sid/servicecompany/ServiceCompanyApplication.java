package org.sid.servicecompany;

import org.sid.servicecompany.DAO.CompanyRepository;
import org.sid.servicecompany.Entity.Company;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class ServiceCompanyApplication {

    public static void main(String[] args) {

        SpringApplication.run(ServiceCompanyApplication.class, args);
    }
    /*on va utiliser la methode qui nous permet de retourner un objet.Et cette methode va
    prendre la notation Bean. et tout ce qui est declaré Bean sont des methodes qui vont s'exécuter au demarrage
     */
 @Bean
CommandLineRunner start(CompanyRepository companyRepository){
     return args -> {
         Stream.of("A", "B", "C").forEach(cn->{
             companyRepository.save(new Company(null, cn, 100+Math.random()*900));
         });
      companyRepository.findAll().forEach(System.out::println);
     };
 }
}
