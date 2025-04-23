package com.designnote.knowledgehub.service.aibank;

import com.designnote.knowledgehub.exception.DbEntityException;
import com.designnote.knowledgehub.pojo.aibank.Stock;
import com.designnote.knowledgehub.repository.aibank.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StockService implements IStockService {

    private static final String NONEXISTENTERROR = "Stock does not exist !";

    @Autowired
    StockRepo stockRepo;

    @Override
    public List<Stock> getAllStocks() {
        return (List<Stock>)stockRepo.findAll();
    }

    @Override
    public Stock getStock(Integer stockID) {
        return stockRepo.findById(stockID).orElseThrow(() -> new DbEntityException(NONEXISTENTERROR));
    }
}
