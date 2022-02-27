package com.project.duo.controller.shop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.duo.model.category.CategoryService;

@Controller
public class ProductController {

	
	//카테고리 소속과 상관없이 모든 상품 다 가져오기 할예정
	@GetMapping("/product/list")
	public ModelAndView selectAll(HttpServletRequest request, @RequestParam(name = "category_id", defaultValue = "0") int category_id) {
		//category_id 0이면, 모든 상품, 0이 아니면 조건 부여 ...
		System.out.println("(1)ProductController selectAll 호출");
		ModelAndView mav = new ModelAndView("shop/product/list");
		
		return mav;
	}
	

	
}


















