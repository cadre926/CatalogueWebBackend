package org.sid.catalogueservice;

import org.sid.catalogueservice.dao.CategorieRepository;
import org.sid.catalogueservice.dao.ProductRepository;
import org.sid.catalogueservice.entities.Category;
import org.sid.catalogueservice.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.stream.Stream;

@SpringBootApplication
public class CatalogueServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalogueServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CategorieRepository cathegorieRepository, ProductRepository productRepository) {


        return args -> {
            Stream.of("C1 Ordinateur", "C2 Imprimmnte","C3 Livres").forEach(c -> {

                cathegorieRepository.save(new Category(c.split(" ")[0], c.split(" ")[1], new ArrayList<>()));


            });

            cathegorieRepository.findAll().forEach(System.out::println);

            productRepository.deleteAll();

            Category c1 = cathegorieRepository.findById("C1").get();

            Stream.of("P1", "P2", "P3", "P4").forEach(name -> {

                Product p1 = productRepository.save(new Product(null, name, Math.random() * 1000, c1));
                c1.getProducts().add(p1);
                cathegorieRepository.save(c1);


            });


            Category c2 = cathegorieRepository.findById("C2").get();

            Stream.of("P5", "P6").forEach(name -> {

                Product p2 = productRepository.save(new Product(null, name, Math.random() * 1000, c2));
                c2.getProducts().add(p2);
                cathegorieRepository.save(c2);


            });

            productRepository.findAll().forEach(product -> {

                System.out.println(product);

            });
        };



    }


}
