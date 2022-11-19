package app.food.inventario.repository;

import app.food.inventario.model.KardexDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KardexDetailRepository extends JpaRepository<KardexDetail,Long> {
}
