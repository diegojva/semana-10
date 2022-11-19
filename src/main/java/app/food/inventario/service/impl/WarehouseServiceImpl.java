package app.food.inventario.service.impl;

import app.food.inventario.model.Warehouse;
import app.food.inventario.repository.WarehouseRepository;
import app.food.inventario.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseRepository repo;

    @Override
    public Warehouse save(Warehouse warehouse) {
        return repo.save(warehouse);
    }

    @Override
    public Warehouse update(Warehouse warehouse) {

        Warehouse updateWarehouse = repo.findById(warehouse.getIdWarehouse()).get();

        if (warehouse.getName() != null) {
            updateWarehouse.setName(warehouse.getName());
            updateWarehouse.setAddress(warehouse.getAddress());
            updateWarehouse.setCity(warehouse.getCity());

            repo.save(updateWarehouse);
        }

        return updateWarehouse;
    }

    @Override
    public Warehouse findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Warehouse> findAll() {
        return repo.findAll();
    }

    @Override
    public void delete(Long id) {
        Warehouse warehouseDB = findById(id);
        if (warehouseDB != null){
            repo.deleteById(warehouseDB.getIdWarehouse());
        }
    }
}
