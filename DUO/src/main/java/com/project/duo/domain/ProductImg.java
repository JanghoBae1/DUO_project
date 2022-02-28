package com.project.duo.domain;

import lombok.Data;

@Data
public class ProductImg {
	private int product_img_id;
	private Product product; //숫자!! product_id, product_name....
	private String img;
	
}