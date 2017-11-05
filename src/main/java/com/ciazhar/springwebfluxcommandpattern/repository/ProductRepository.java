package com.ciazhar.springwebfluxcommandpattern.repository;

import com.ciazhar.springwebfluxcommandpattern.model.mongo.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Created by ciazhar on 11/5/17.
 * <p>
 * [ Documentation Here ]
 */
public interface ProductRepository extends ReactiveMongoRepository<Product,String>{
}
