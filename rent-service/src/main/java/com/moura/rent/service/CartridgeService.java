package com.moura.rent.service;

import com.moura.rent.model.dto.CartridgeResponseDTO;
import com.moura.rent.model.entity.Cartridge;
import com.moura.rent.model.repository.CartridgeRepository;
import com.moura.rent.model.vo.GameVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartridgeService {
    @Autowired
    private CartridgeRepository cartridgeRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Cartridge save(Cartridge cartridge) {
        return cartridgeRepository.save(cartridge);
    }

    public Cartridge findCartridgeById(Long cartridgeId) {
        Cartridge cartridge = cartridgeRepository.findById(cartridgeId).get();
        return cartridge;
    }

    public CartridgeResponseDTO getCartridgesWithGame(Long gameId) {

        CartridgeResponseDTO dto = new CartridgeResponseDTO();
        List<Cartridge> cartridges = cartridgeRepository.findAllByGameId(gameId).get();

        GameVO game = restTemplate.getForObject("http://RETRO-SERVICE/games/" + gameId, GameVO.class);

        if(!cartridges.isEmpty() && game != null){
            dto.setCartridges(cartridges);
            dto.setGame(game);
        } else {
            throw new RuntimeException("");
        }

        return dto;
    }
}
