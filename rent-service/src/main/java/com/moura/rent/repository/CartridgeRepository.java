package com.moura.rent.repository;

import com.moura.rent.entity.Cartridge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartridgeRepository extends JpaRepository<Cartridge, Long> {
}
