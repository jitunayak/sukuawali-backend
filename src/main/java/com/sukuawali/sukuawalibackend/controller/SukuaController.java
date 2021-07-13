package com.sukuawali.sukuawalibackend.controller;

import com.sukuawali.sukuawalibackend.models.Sukua;
import com.sukuawali.sukuawalibackend.services.SukuaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/sukuas")
public class SukuaController {

    @Autowired
    SukuaService sukuaService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Sukua>> getAllSukuas() {
        try {
            Optional<List<Sukua>> sukuas = sukuaService.getAllSukuas();
            if (sukuas.isPresent()) return new ResponseEntity(Optional.of(sukuas), HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity(Optional.empty(), HttpStatus.NOT_FOUND);
        }
        return null;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Sukua> addNewSukua(@RequestBody Sukua sukua) {
        try {
            return new ResponseEntity(sukuaService.addNewSukua(sukua), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            log.debug(String.valueOf(e.getStackTrace()));
            return new ResponseEntity("Could not add", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Sukua> updateExistingSukuaItem(@RequestBody Sukua sukua) {
        return new ResponseEntity(sukuaService.updateSukuaItem(sukua), HttpStatus.ACCEPTED);
    }
}
