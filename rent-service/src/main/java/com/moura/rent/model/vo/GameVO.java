package com.moura.rent.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameVO {
    private Long id;
    private String name;
    private Set<String> genreSet;
    private Set<String> platformSet;
}
