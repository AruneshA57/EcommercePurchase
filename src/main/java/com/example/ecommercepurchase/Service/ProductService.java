package com.example.ecommercepurchase.Service;

import com.example.ecommercepurchase.Respository.ProductRepository;
import com.example.ecommercepurchase.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService {


    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    //********* PostMapping Adding product to the database *********//

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> addProductList(List<Product> products){
        return productRepository.saveAll(products);
    }



    //********* Get product/s from the database **********//

    public Product getProduct(Long productId){
        return productRepository.getProductByProductId(productId);
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    //********* update product from the database *********//

    public Product updateProduct(Product product){
        return productRepository.save(product);
    }




    //********* delete product/s from the database *********//


    public void delete(Long productId){
        productRepository.deleteProductByProductId(productId);
    }

    public void deleteAll(){
        productRepository.deleteAll();
    }




}
