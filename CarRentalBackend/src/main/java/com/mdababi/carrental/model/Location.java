package com.mdababi.carrental.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location extends BaseEntity implements Serializable {

    @NonNull
    @NotBlank(message = "City name is mandatory")
    private String city ;

}
