package com.mdababi.carrental.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rental implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @FutureOrPresent(message = "{Must be future or present}")
    @NotNull(message = "{Pickup Date is mandatory}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickupDate;

    @FutureOrPresent(message = "{Must be future or present}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dropOffDate;

    @ManyToOne
    @NotNull(message = "{customer is mandatory}")
    private Customer customer;

    @OneToOne
    @NotNull(message = "{Pickup location is mandatory}")
    private Location pickupLocation;


    @OneToOne
    @NotNull(message = "{Drop off location is mandatory}")
    private Location dropOffLocation;

}
