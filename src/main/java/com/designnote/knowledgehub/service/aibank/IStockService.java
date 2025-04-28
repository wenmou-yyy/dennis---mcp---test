package com.designnote.knowledgehub.service.aibank;

import com.designnote.knowledgehub.pojo.aibank.Stock;
import com.designnote.knowledgehub.pojo.aibank.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IStockService {

    Stock getStock(Integer stockID);
    
    List<Stock> getAllStocks();

}
