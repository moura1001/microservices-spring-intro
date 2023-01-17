package com.moura.rent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cartridge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartridgeId;
    private Integer remainingCartridge;
    private String cartridgeCode;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime latestRent;
}
