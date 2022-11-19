package app.food.inventario.controller;

import app.food.inventario.model.Warehouse;
import app.food.inventario.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseService service;

    @PostMapping
    public ResponseEntity<Warehouse> save(@RequestBody Warehouse warehouse){
        Warehouse newWarehouse = service.save(warehouse);
        return new ResponseEntity<Warehouse>(newWarehouse, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Warehouse> update(@RequestBody Warehouse warehouse){
        Warehouse newWarehouse = service.update(warehouse);
        return new ResponseEntity<Warehouse>(newWarehouse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Warehouse>> getAll(){
        List<Warehouse> warehouses = service.findAll();
        return new ResponseEntity<List<Warehouse>>(warehouses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Warehouse> findById(@PathVariable("id") Long id){
        Warehouse foundWarehouse = service.findById(id);

        if(foundWarehouse == null) {return new ResponseEntity<Warehouse>(HttpStatus.NOT_FOUND);};

        return new ResponseEntity<Warehouse>(foundWarehouse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Warehouse> delete(@PathVariable("id") Long id){
        Warehouse foundWarehouse = service.findById(id);

        if(foundWarehouse == null) {return new ResponseEntity<Warehouse>(HttpStatus.NOT_FOUND);};

        service.delete(id);
        return new ResponseEntity<Warehouse>(HttpStatus.NO_CONTENT);
    }
}
