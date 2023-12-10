package com.mogila.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String typeBrand;

    @Column(nullable = false)
    private String registryNumber;

    @Column(nullable = false)
    private String inventoryNumber;

    @Column(nullable = false)
    private Integer verificationPeriod;

    @Column(nullable = false)
    private String note;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "device_id")
    private List<Verification> verifications;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "device_id")
    private List<Repair> repairs;
}
