package app.food.inventario.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KardexDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idKardexDetail;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    private Kardex kardex;

    private Date date;
    private String operationType;
    private String descripcion;
    private Double cant;
    private Double stock;
}
