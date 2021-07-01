package one.digitalinoovation.experts.productcatalog.controller;


import one.digitalinoovation.experts.productcatalog.model.Product;
import one.digitalinoovation.experts.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/save")
    public Product create(@RequestBody Product product){
        productRepository.save(product);
        return product;
    }

    @GetMapping("/list/{id}")
    public Optional<Product> findById(@PathVariable Long id){
        return productRepository.findById(id);
    }

    @GetMapping("/list")
    public Iterable<Product> listAll(){
        return productRepository.findAll();
    }


}
