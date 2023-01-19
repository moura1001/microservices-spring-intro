package com.moura.rent.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cartridge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartridgeId;
    @Column(columnDefinition = "INTEGER NOT NULL DEFAULT 0")
    @Min(0)
    private Integer remainingCartridge;
    @Column(length = 2, nullable = false)
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private CartridgeRegion cartridgeRegion;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime latestRent;

    @NotNull @Min(0)
    @Column(columnDefinition = "INTEGER NOT NULL")
    private Long gameId;
}
