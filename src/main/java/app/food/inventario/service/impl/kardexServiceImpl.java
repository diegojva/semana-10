package app.food.inventario.service.impl;

import app.food.inventario.dto.ProductDTO;
import app.food.inventario.model.Kardex;
import app.food.inventario.model.KardexDetail;
import app.food.inventario.model.Product;
import app.food.inventario.repository.KardexDetailRepository;
import app.food.inventario.repository.KardexRepository;
import app.food.inventario.service.ProductService;
import app.food.inventario.service.kardexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class kardexServiceImpl implements kardexService {

    @Autowired
    private KardexRepository kardexRepository;

    @Autowired
    private KardexDetailRepository kardexDetailRepository;

    @Autowired
    private ProductService productService;

    @Transactional
    @Override
    public Boolean registerKardexOut(List<ProductDTO> products) {
        products.forEach(prod -> {
            List<Kardex> kardexes = this.findKardexByProduct(prod.getIdProduct());
            this.stockValidate(kardexes, prod.getCant());
            Boolean isRegister = this.registerOut(kardexes, prod.getCant(), prod.getDescription());
        });
        return true;
    }

    private List<Kardex> findKardexByProduct(Long idProduct){
        Product productDB = productService.findProductById(idProduct);
        return kardexRepository.findKardexByProduct(productDB);
    }

    private void stockValidate(List<Kardex> kardexes, Double cant){
        Double currentStock = kardexes.stream()
                .mapToDouble(Kardex::getCurrentBalance)
                .sum();
        if(currentStock<cant){
            //retornar excepcion
        }
    }

    private Boolean registerOut(List<Kardex> kardexes, Double cant, String description) {
        for(Kardex kardex: kardexes){
            if(kardex.getCurrentBalance()>=cant){
                Double currentBalance = kardex.getCurrentBalance() - cant;
                KardexDetail detail = KardexDetail.builder()
                        .cant(cant)
                        .descripcion(description)
                        .operationType("out")
                        .stock(currentBalance)
                        .kardex(kardex)
                        .build();
                kardexDetailRepository.save(detail);
                kardex.setCurrentBalance(currentBalance);
                kardexRepository.save(kardex);
                return true;
            }else{
                cant -= kardex.getCurrentBalance();
                KardexDetail detail = KardexDetail.builder()
                        .cant(kardex.getCurrentBalance())
                        .descripcion(description)
                        .operationType("out")
                        .stock(0.0)
                        .kardex(kardex)
                        .build();
                kardexDetailRepository.save(detail);

                kardex.setCurrentBalance(0.0);
                kardexRepository.save(kardex);
            }
        };
        return true;
    }
}

