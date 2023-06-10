package com.example.Tienda.domain;

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
@EqualsAndHashCode(of = "Map")
public class Map {
    @Min(value = 0)
    @Id
    @GeneratedValue
    private Map map2;
    @NotEmpty
    private Map map;

    public Map(@NotEmpty Map map) {
        this.map = map;
    }
}
