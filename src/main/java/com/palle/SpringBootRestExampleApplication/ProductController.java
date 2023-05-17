package com.palle.SpringBootRestExampleApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//handle all http requests
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id){
        return productService.getProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product product){
        Product existingProduct = productService.getProductById(id);
        if(existingProduct == null){
            return null;
        }
        existingProduct.setPname(product.getPname());
        existingProduct.setBatchno(product.getBatchno());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setNoofproduct(product.getNoofproduct());
        return productService.saveProduct(existingProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteCustomer(id);
    }

}
