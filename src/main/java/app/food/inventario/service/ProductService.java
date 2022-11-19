package app.food.inventario.service;

import app.food.inventario.model.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);

    Product findProductById(Long id);

    List<Product> findAll();
}
