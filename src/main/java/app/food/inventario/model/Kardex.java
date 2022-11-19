package app.food.inventario.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Kardex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCardex;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "id_warehouse",  foreignKey = @ForeignKey(name = "FK_WAREHOUSE_CARDEX"))
    private Warehouse warehouse;

    private Double currentBalance;

}
