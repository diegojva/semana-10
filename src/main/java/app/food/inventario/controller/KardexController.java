package app.food.inventario.controller;


import app.food.inventario.dto.ProductDTO;
import app.food.inventario.model.Kardex;
import app.food.inventario.service.kardexService;
import app.food.inventario.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Kardex")
public class KardexController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private kardexService kardexService;

    @PostMapping("/register-out")
    public ResponseEntity<Boolean> registerOut(@RequestBody List<ProductDTO> products){
        Boolean isRegister = kardexService.registerKardexOut(products);
        return ResponseEntity.ok(isRegister);
    }
}
