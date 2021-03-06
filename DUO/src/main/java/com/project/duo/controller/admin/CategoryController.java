package com.project.duo.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.duo.domain.Category;
import com.project.duo.exception.CategoryException;
import com.project.duo.model.category.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	//카테고리 목록 요청 처리 
	@GetMapping("/category/list")
	public ModelAndView getList() {
		ModelAndView mav = new ModelAndView("admin/category/list");
		List categoryList = categoryService.selectAll(); //3단계: 일시키기 
		mav.addObject("categoryList", categoryList); //4단계: 저장
		return mav;		
	}
	
	//카테고리 등록폼
	@GetMapping("/category/registform")
	public String registForm() {
		return "admin/category/regist";
	}
	
	@PostMapping("/category/regist")
	public String regist(Category category) {
		categoryService.insert(category);//3단계: 카테고리 등록
		
		return "redirect:/admin/category/list";
	}
	
	@GetMapping("/category/detail")
	public String getDetail(int category_id, Model model) {
		//3단계: 한건의 데이터 가져오기 
		Category category=categoryService.select(category_id);
		
		model.addAttribute("category", category);//4단계: 저장
		
		return "admin/category/detail";
	}
	
	//서브카테고리 등록 요청 
	@PostMapping("/category/registsub")
	public String registSub(Category category) { // category_name, team, step, depth  (내본글)
		//3단계:
		categoryService.registSub(category);
		
		return "redirect:/admin/category/list";
	}
	
	
	@ExceptionHandler(CategoryException.class)
	public ModelAndView handle(CategoryException e) {
		ModelAndView mav = new ModelAndView("admin/error/result");
		mav.addObject("e", e);//결과 저장
		return mav;
	}
}






