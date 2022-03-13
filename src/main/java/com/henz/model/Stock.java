package com.henz.model;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;


/**
 * 
 * see also /SpringRestUsingJson2 for annotations
 * 
 * */

@Data
public class Stock{
	
	@NotNull
	@Size(max=10)
	private String id;
	
	@NotNull 
	@Size(max = 10) 
	private String name;
	
	@NotNull
	@DecimalMin("0.01")
	private Double price;
}
