package com.henz.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henz.data_access.StockDao;
import com.henz.model.Stock;

@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class StockController {
	
	@Resource
	@Qualifier("jdbc") //inject the StockJdbcDao implementation
	private StockDao stockDao;
	
	@GetMapping("/stock/{id}")
	public Stock getInfo(@PathVariable("id") String id) {
		Stock stock = this.stockDao.findById(id);
		if(stock == null) {
			//see /SpringRestUsingJson2 for exception handling
			throw new IllegalStateException("sorry not found");
		}
		
		return stock;
	}
	
	@PostMapping("/stock/{id}")
	public void save(@PathVariable("id") String id, @RequestBody Stock stock) {
		this.stockDao.save(stock);
	}

}
