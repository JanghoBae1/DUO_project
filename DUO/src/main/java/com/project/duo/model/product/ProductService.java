package com.project.duo.model.product;

import java.util.List;

import com.project.duo.domain.Product;
import com.project.duo.domain.ProductImg;

//제품을 관리하는 서비스 
public interface ProductService {
	
	public List selectAll();
	public List selectAllByCategory(int category);
	public Product select(int product_id); //한건 가져오기
	public void regist(Product product, List<ProductImg> productImgList);
	public void update(Product product); 
	public void delete(int product_id);
	
}
