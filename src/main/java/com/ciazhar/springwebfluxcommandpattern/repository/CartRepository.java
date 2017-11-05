package com.ciazhar.springwebfluxcommandpattern.repository;

import com.ciazhar.springwebfluxcommandpattern.model.mongo.Cart;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Created by ciazhar on 11/5/17.
 * <p>
 * [ Documentation Here ]
 */
public interface CartRepository extends ReactiveMongoRepository<Cart,String>{
}
