package com.designnote.knowledgehub.controller;

import com.designnote.knowledgehub.pojo.ResponseMessage;
import com.designnote.knowledgehub.pojo.aibank.Stock;
import com.designnote.knowledgehub.service.aibank.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

//@CrossOrigin(origins = "http://localhost", maxAge = 3600)
@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    IStockService service;

    @CrossOrigin
    @GetMapping("/{stockID}")
    public ResponseMessage<Stock> get(@PathVariable("stockID") String stockID){

        int n = Integer.parseInt(stockID);
        Stock stock = service.getStock(n);
        List<Stock> results = new ArrayList<>();
        results.add(stock);
        return ResponseMessage.success(results);
    }

    @CrossOrigin
    @GetMapping
    public ResponseMessage<Stock> getAllStocks(){
        List<Stock> results = service.getAllStocks();
        return ResponseMessage.success(results);
    }

}
