package com.ciazhar.springwebfluxcommandpattern.controller;

import com.ciazhar.springwebfluxcommandpattern.model.mongo.Cart;
import com.ciazhar.springwebfluxcommandpattern.model.request.*;
import com.ciazhar.springwebfluxcommandpattern.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * Created by ciazhar on 11/5/17.
 * <p>
 * [ Documentation Here ]
 */

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired private CartService service;

    @PostMapping("/create")
    public Mono<Cart> createCart(@Valid @RequestBody CreateCartRequest request){
        return service.createCart(request);
    }

    @PostMapping("/detail")
    public Mono<Cart> cartDetail(@Valid @RequestBody GetCartDetailRequest request){
        return service.cartDetail(request);
    }

    @PostMapping("/add")
    public Mono<Cart> addProductToCart(@Valid @RequestBody AddProductToCartRequest request){
        return service.addProductToCart(request);
    }

    @PostMapping("/update")
    public Mono<Cart> updateProductInCart(@Valid @RequestBody UpdateProductInCartRequest request){
        return service.updateProductInCart(request);
    }

    @PostMapping("/delete")
    public Mono<Cart> deleteProductFromCart(@Valid @RequestBody DeleteProductInCartRequest request){
        return service.deleteProductInCart(request);
    }

}
