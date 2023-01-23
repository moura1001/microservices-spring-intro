package com.moura.rent.model.dto;

import com.moura.rent.model.entity.Cartridge;
import com.moura.rent.model.vo.GameVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartridgeResponseDTO {
    private GameVO game;
    private List<Cartridge> cartridges;
}
