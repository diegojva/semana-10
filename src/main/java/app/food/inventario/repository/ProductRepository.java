package app.food.inventario.repository;

import app.food.inventario.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Modifying
    @Query(value = "INSERT INTO product(id_cardex, name, category) VALUES(:idCardex, :name, :category)", nativeQuery = true)
    Integer saveProduct(@Param("idCardex") Long idCardex, @Param("name") String name, @Param("category") String category);

    
}
