package com.designnote.knowledgehub.repository.aibank;

import com.designnote.knowledgehub.pojo.aibank.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepo extends CrudRepository<Stock,Integer> {
}
