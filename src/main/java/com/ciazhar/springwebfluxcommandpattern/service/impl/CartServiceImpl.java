package com.ciazhar.springwebfluxcommandpattern.service.impl;

import com.ciazhar.springwebfluxcommandpattern.model.*;
import com.ciazhar.springwebfluxcommandpattern.model.mongo.Cart;
import com.ciazhar.springwebfluxcommandpattern.model.mongo.Product;
import com.ciazhar.springwebfluxcommandpattern.model.request.*;
import com.ciazhar.springwebfluxcommandpattern.repository.CartRepository;
import com.ciazhar.springwebfluxcommandpattern.repository.ProductRepository;
import com.ciazhar.springwebfluxcommandpattern.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Created by ciazhar on 11/5/17.
 * <p>
 * [ Documentation Here ]
 */

@Service
public class CartServiceImpl implements CartService {

    @Autowired private CartRepository cartRepository;
    @Autowired private ProductRepository productRepository;

    @Override
    public Mono<Cart> createCart(CreateCartRequest request) {
        Cart cart = Cart.builder().id(request.getCartId()).build();
        return cartRepository.save(cart);
    }

    @Override
    public Mono<Cart> addProductToCart(AddProductToCartRequest request) {
        return Mono.zip(
            objects -> addOrUpdateProductInCart((Cart) objects[0],(Product) objects[1],request.getQuantity()),
                cartRepository.findById(request.getCartId()),
                productRepository.findById(request.getProductId())
        ).flatMap(cart -> cartRepository.save(cart));
    }

    private Cart addOrUpdateProductInCart(Cart cart, Product product, Integer quantity) {
        if (isCartContainProduct(cart, product)) {
            incrementProductQuantity(cart, product, quantity);
        } else {
            addNewProductToCart(cart, product, quantity);
        }

        return cart;
    }

    private boolean isCartContainProduct(Cart cart, Product product) {
        return cart.getItems().stream()
                .anyMatch(cartItem -> cartItem.getId().equals(product.getId()));
    }

    private void incrementProductQuantity(Cart cart, Product product, Integer quantity) {
        cart.getItems().stream()
                .filter(cartItem -> cartItem.getId().equals(product.getId()))
                .forEach(cartItem -> cartItem.setQuantity(cartItem.getQuantity() + quantity));
    }

    private void addNewProductToCart(Cart cart, Product product, Integer quantity) {
        CartItem item = new CartItem(product.getId(),product.getName(),product.getPrice(),quantity);
        cart.getItems().add(item);
    }

    @Override
    public Mono<Cart> cartDetail(GetCartDetailRequest request) {
        return cartRepository.findById(request.getCartId());
    }

    @Override
    public Mono<Cart> updateProductInCart(UpdateProductInCartRequest request) {
        return Mono.zip(
            objects -> updateCartItemQuantity((Cart) objects[0],(Product) objects[1],request.getQuantity()),
                cartRepository.findById(request.getCartId()),
                productRepository.findById(request.getCartId())
        ).flatMap(cart -> cartRepository.save(cart));
    }

    private Cart updateCartItemQuantity(Cart cart, Product product, Integer quantity) {
        cart.getItems().stream()
                .filter(cartItem -> cartItem.getId().equals(product.getId()))
                .forEach(cartItem -> cartItem.setQuantity(cartItem.getQuantity() + quantity));
        return cart;
    }

    @Override
    public Mono<Cart> deleteProductInCart(DeleteProductInCartRequest request) {
        return Mono.zip(objects ->
                deleteItemFromCart((Cart)objects[0],findItemInCart((Cart) objects[0],request.getProductId())),
                cartRepository.findById(request.getCartId())
        ).flatMap(cart -> cartRepository.save(cart));
    }

    private CartItem findItemInCart(Cart cart, String productId){
        return cart.getItems().stream()
                .filter(cartItem -> cartItem.getId().equals(productId))
                .findFirst()
                .get();
    }

    private Cart deleteItemFromCart(Cart cart, CartItem cartItem){
        cart.getItems().remove(cartItem);
        return cart;
    }
}
