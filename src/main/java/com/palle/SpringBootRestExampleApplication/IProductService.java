package com.palle.SpringBootRestExampleApplication;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductService extends JpaRepository<Product, Integer> {
}
