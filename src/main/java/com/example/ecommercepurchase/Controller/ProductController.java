package com.example.ecommercepurchase.Controller;

import com.example.ecommercepurchase.Service.ProductService;
import com.example.ecommercepurchase.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
@RequestMapping("/Product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) throws Throwable{
        Product product = productService.getProduct(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> products = productService.getAllProduct();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }



    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        Product updateProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updateProduct,HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        productService.delete(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteProduct(){
        productService.deleteAll();
    }


}
