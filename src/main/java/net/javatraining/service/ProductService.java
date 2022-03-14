package net.javatraining.service;

import net.javatraining.model.Product;
import net.javatraining.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAll(){
        return productRepository.findAll();
    }

    public void saveProduct(Product product){
        productRepository.save(product);
    }

    public Product getProduct(Long id){
        return productRepository.findById(id).get();
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
