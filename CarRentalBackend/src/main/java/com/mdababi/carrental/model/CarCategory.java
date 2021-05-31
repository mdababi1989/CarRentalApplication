package com.mdababi.carrental.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarCategory  extends BaseEntity implements Serializable {

    @NonNull
    @NotBlank(message = "category name is mandatory")
    private String categoryName ;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    @Getter(AccessLevel.NONE)
    @JsonManagedReference
    private List<Car> carList = new ArrayList<>();


    public void addCar(Car car){
        carList.add(car);
    }

    public void removeCar(Car car){
        carList.remove(car);
    }

    public List<Car> getCarsList(){
        return new ArrayList<>(carList);
    }

}
