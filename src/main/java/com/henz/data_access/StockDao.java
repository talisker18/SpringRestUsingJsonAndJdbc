package com.henz.data_access;

import com.henz.model.Stock;

public interface StockDao {
	
	Stock findById(String id);
	void save(Stock stock);

}
