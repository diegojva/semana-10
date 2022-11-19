package app.food.inventario.dto;

import app.food.inventario.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KardexProductDTO {
    private List<Product> products;
}
