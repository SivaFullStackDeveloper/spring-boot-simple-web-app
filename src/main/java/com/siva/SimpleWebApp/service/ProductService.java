package com.siva.SimpleWebApp.service;

import com.siva.SimpleWebApp.model.Product;
import com.siva.SimpleWebApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    List<Product> products = new ArrayList<>(
            Arrays.asList(
                    new Product(101, "Iphone", 70000),
                    new Product(102, "Mac book", 170000),
                    new Product(103, "Lenovo Think Pad", 80000)
            )
    );


    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void updateProduct(Product product) {

        productRepository.save(product);
    }

    public void deleteProduct(int id) {

        productRepository.deleteById(id);
    }

    public int returnIndex(int id) {
        int index = 0;
        for (int i = 0; i < products.size(); i++)
            if (products.get(i).getProductId() == id)
                index = i;

        return index;
    }

}
