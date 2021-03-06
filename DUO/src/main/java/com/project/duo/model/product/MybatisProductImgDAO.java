package com.project.duo.model.product;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.duo.domain.ProductImg;
import com.project.duo.exception.ProductImgException;

@Repository
public class MybatisProductImgDAO implements ProductImgDAO{

	@Autowired
	private SqlSessionTemplate sessionTemplate;

	public void insert(ProductImg productImg) throws ProductImgException{
		int result=sessionTemplate.insert("ProductImg.insert", productImg);
		if(result==0) {
			throw new ProductImgException("상품 사진 insert 실패");
		}
	}

}
