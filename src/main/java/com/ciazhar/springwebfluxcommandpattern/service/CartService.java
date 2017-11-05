package com.ciazhar.springwebfluxcommandpattern.service;

import com.ciazhar.springwebfluxcommandpattern.model.request.AddProductToCartRequest;
import com.ciazhar.springwebfluxcommandpattern.model.request.DeleteProductInCartRequest;
import com.ciazhar.springwebfluxcommandpattern.model.request.GetCartDetailRequest;
import com.ciazhar.springwebfluxcommandpattern.model.request.UpdateProductInCartRequest;
import com.ciazhar.springwebfluxcommandpattern.model.mongo.Cart;
import com.ciazhar.springwebfluxcommandpattern.model.request.CreateCartRequest;
import reactor.core.publisher.Mono;

/**
 * Created by ciazhar on 11/5/17.
 * <p>
 * [ Documentation Here ]
 */
public interface CartService {
    Mono<Cart> createCart(CreateCartRequest request);
    Mono<Cart> addProductToCart(AddProductToCartRequest request);
    Mono<Cart> cartDetail(GetCartDetailRequest request);
    Mono<Cart> updateProductInCart(UpdateProductInCartRequest request) ;
    Mono<Cart> deleteProductInCart(DeleteProductInCartRequest request);
}
