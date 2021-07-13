package com.sukuawali.sukuawalibackend.services;

import com.sukuawali.sukuawalibackend.models.Sukua;
import com.sukuawali.sukuawalibackend.repositories.SukuaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SukuaService {

    @Autowired
    SukuaRepository sukuaRepository;

    public Optional<List<Sukua>> getAllSukuas() {
        return Optional.of(sukuaRepository.findAll());
    }

    public Optional<Sukua> addNewSukua(Sukua sukua) {
        return Optional.of(sukuaRepository.save(sukua));
    }

    public Optional<Sukua> updateSukuaItem(Sukua sukua) {
        return Optional.of(sukuaRepository.save(sukua));
    }
}
