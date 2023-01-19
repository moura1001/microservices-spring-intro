package com.moura.rent.model.repository;

import com.moura.rent.model.entity.Cartridge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartridgeRepository extends JpaRepository<Cartridge, Long> {
}
