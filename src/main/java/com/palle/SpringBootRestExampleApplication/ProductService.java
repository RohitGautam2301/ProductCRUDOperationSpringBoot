package com.palle.SpringBootRestExampleApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//uses the repository to perform database operations
@Service
public class ProductService {
    @Autowired
    private IProductService iProductService;

    public ProductService(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    //read, save, delete
    public List<Product> getAllProducts() {
        return iProductService.findAll();
    }
    public Product getProductById(Integer id){
        return iProductService.findById(id).orElse(null);
    }
    public Product saveProduct(Product product){
        return iProductService.save(product);
    }
    public void deleteCustomer(Integer id){
        iProductService.deleteById(id);
    }
}
