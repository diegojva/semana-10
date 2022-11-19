package app.food.inventario.service;

import app.food.inventario.dto.ProductDTO;
import app.food.inventario.model.Kardex;
import app.food.inventario.model.Product;

import java.util.List;

public interface kardexService {
    Boolean registerKardexOut(List<ProductDTO> products);
}
