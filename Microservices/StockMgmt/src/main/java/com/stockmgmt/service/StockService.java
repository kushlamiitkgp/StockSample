package com.stockmgmt.service;

import com.stockmgmt.database.Stocks;

public interface StockService {

    Stocks getById(Long id);
}
