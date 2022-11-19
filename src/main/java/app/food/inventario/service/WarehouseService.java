package app.food.inventario.service;

import app.food.inventario.model.Warehouse;

import java.util.List;

public interface WarehouseService {
     Warehouse save(Warehouse warehouse);

     Warehouse update(Warehouse warehouse);

     Warehouse findById(Long id);

     List<Warehouse> findAll();

     void delete(Long id);
}
