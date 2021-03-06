package com.project.duo.model.product;

import java.util.List;

import com.project.duo.domain.Product;

public interface ProductDAO {
	public List selectAll();
	public List selectAllByCategory(int category_id);
	public Product select(int product_id); //한건 가져오기
	public void insert(Product product);
	public void update(Product product); 
	public void delete(int product_id);
	
}
