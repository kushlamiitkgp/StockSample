package com.stockmgmt.service;

import com.stockmgmt.database.Stocks;
import com.stockmgmt.database.StocksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockServiceImpl implements StockService{
    @Autowired
    StocksRepository stocksRepository;

    public Stocks getById(Long id){
        Optional<Stocks> stocks = stocksRepository.findById(id);
        return stocks.get();
    }
}
