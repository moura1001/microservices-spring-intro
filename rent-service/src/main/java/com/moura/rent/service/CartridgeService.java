package com.moura.rent.service;

import com.moura.rent.entity.Cartridge;
import com.moura.rent.repository.CartridgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartridgeService {
    @Autowired
    private CartridgeRepository cartridgeRepository;

    public Cartridge save(Cartridge cartridge) {
        return cartridgeRepository.save(cartridge);
    }

    public Cartridge findCartridgeById(Long cartridgeId) {
        Cartridge cartridge = cartridgeRepository.findById(cartridgeId).get();
        return cartridge;
    }
}
