package com.moura.rent.model.repository;

import com.moura.rent.model.dto.CartridgeResponseDTO;
import com.moura.rent.model.entity.Cartridge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartridgeRepository extends JpaRepository<Cartridge, Long> {
    Optional<List<Cartridge>> findAllByGameId(Long gameId);
}
