package com.moura.retro.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotNull @NotBlank
    private String name;

    @ElementCollection(targetClass = GameGenre.class)
    @CollectionTable(name = "game_genre", joinColumns = @JoinColumn(name = "game_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "genre_name", nullable = false)
    @NotEmpty @Valid
    private Set<GameGenre> genreSet;

    @ElementCollection(targetClass = GamePlatform.class)
    @CollectionTable(name = "game_platform", joinColumns = @JoinColumn(name = "game_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "platform_name", nullable = false)
    @NotEmpty @Valid
    private Set<GamePlatform> platformSet;
}
