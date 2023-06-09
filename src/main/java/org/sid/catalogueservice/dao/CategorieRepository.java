package org.sid.catalogueservice.dao;

import org.sid.catalogueservice.entities.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CategorieRepository extends MongoRepository<Category,String> {
}
