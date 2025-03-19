package com.stockmgmt.rest;

import com.stockmgmt.database.Stocks;
import com.stockmgmt.service.StockHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    StockHandler stockHandler;

    @PostMapping(value = "/get/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {

        Stocks ans = stockHandler.getById(id);
        if (null != ans) {
            return ResponseEntity.ok(ans);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid id "+id);
        }
    }

}
