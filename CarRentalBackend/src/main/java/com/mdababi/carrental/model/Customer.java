package com.mdababi.carrental.model;


import com.mdababi.carrental.validation.ValidPassword;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity implements Serializable {

    @Size(min = 1, max = 255, message = "{firstname length must be between 1 and 255}")
    @NotNull(message = "{firstname is mandatory}")
    private String firstname;

    @Size(min = 1, max = 255, message = "{lastname length must be between 1 and 255}")
    @NotNull(message = "{lastname is mandatory}")
    private String lastname;

    @Size(min = 6, max = 255, message = "{username length must be between 6 and 255}")
    @NotNull(message = "{username is mandatory}")
    private String username;

    @ValidPassword
    @NonNull
    @NotBlank(message = "New password is mandatory")
    private String password;

    @OneToMany(mappedBy = "customer")
    @Getter(AccessLevel.NONE)
    private List<Rental> rentalList = new ArrayList<>();


    public void addRental(Rental rental){
        rentalList.add(rental);
    }

    public void removeCar(Rental rental){
        rentalList.remove(rental);
    }

    public List<Rental> getRentalList(){
        return new ArrayList<>(rentalList);
    }

}
