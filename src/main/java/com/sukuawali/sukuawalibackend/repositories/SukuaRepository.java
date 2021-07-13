package com.sukuawali.sukuawalibackend.repositories;

import com.sukuawali.sukuawalibackend.models.Sukua;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SukuaRepository extends JpaRepository<Sukua, Long> {

}
