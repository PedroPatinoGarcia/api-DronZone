package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@EqualsAndHashCode(of = "id")
public class Dron {
    @Min(value = 0)
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String nombre;

    public Dron(@NotEmpty String nombre) {
        this.nombre = nombre;
    }
}