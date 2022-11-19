package app.food.inventario.repository;

import app.food.inventario.model.Kardex;
import app.food.inventario.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KardexRepository extends JpaRepository<Kardex,Long> {

    List<Kardex> findKardexByProduct(Product product);
}
