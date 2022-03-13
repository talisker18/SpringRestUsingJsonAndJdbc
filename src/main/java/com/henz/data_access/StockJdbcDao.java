package com.henz.data_access;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.henz.model.Stock;

@Repository
@Qualifier("jdbc")
public class StockJdbcDao implements StockDao{
	
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Override
	public Stock findById(String id) {
		String query = "select * from stocks where id = ?";
		return this.jdbcTemplate.queryForObject(query, new Object[] {id}, new BeanPropertyRowMapper<>(Stock.class));
	}

	@Override
	@Transactional
	public void save(Stock stock) {
		String query = "merge into stocks key(id) values(?,?,?)";
		this.jdbcTemplate.update(query,stock.getId(),stock.getName(),stock.getPrice());
		
	}

}
