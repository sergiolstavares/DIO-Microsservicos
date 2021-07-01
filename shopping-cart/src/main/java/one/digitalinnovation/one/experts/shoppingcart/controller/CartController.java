package one.digitalinnovation.one.experts.shoppingcart.controller;

import one.digitalinnovation.one.experts.shoppingcart.model.Cart;
import one.digitalinnovation.one.experts.shoppingcart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @PostMapping("/save/{id}")
    public Cart addItem(@PathVariable Integer id){
        Optional<Cart> savedCart = cartRepository.findById(id);
        Cart cart;
        if(savedCart.equals(Optional.empty())){
            cart = new Cart(id);
        }else{
            cart = savedCart.get();
        }
        return cartRepository.save(cart);
    }

    @GetMapping("/list/{id}")
    public Optional<Cart> findById(@PathVariable Integer id){
        return cartRepository.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void clear(@PathVariable Integer id){
        cartRepository.deleteById(id);
    }
}
