package com.mogila.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class Verification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private LocalDate dateOfVerification;

    @Column(nullable = false)
    private String verificationPlace;

    @Column(nullable = false)
    private String typeOfVerification;

    @Column(nullable = false)
    private String conclusion;
}
