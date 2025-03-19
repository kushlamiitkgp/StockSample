package com.stockmgmt.service;


import com.stockmgmt.database.Stocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StockHandler {
    @Autowired
    private StockService stockService;

    public Stocks getById(Long id){
        return stockService.getById(id);
    }

}
