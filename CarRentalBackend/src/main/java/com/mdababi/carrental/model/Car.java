package com.mdababi.carrental.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mdababi.carrental.model.enums.CarType;
import com.mdababi.carrental.model.enums.Transmission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car extends BaseEntity implements Serializable {

    @ManyToOne
    @JsonBackReference
    private CarCategory category;

    @NotBlank(message = "{Model is mandatory}")
    private String model;

    @NotNull(message = "{capacity is mandatory}")
    @Range(min = 1, max = 5, message = "{capacity must be included between 1 and 5}")
    private Integer capacity; //passengers

    @NotNull(message = "{The car type is mandatory}")
    private CarType carType;

    @NotNull(message = "{The Doors number is mandatory}")
    @Range(min = 1, max = 5, message = "{Doors number must be included between 1 and 5}")
    private Integer doors;

    @NotNull(message = "{The transmission type is mandatory}")
    private Transmission transmission;

    @NotNull(message = "{The price per day is mandatory}")
    private Integer pricePerDay;
}
