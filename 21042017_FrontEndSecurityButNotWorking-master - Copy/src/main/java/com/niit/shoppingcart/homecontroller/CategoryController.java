package com.niit.shoppingcart.homecontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

@Controller
public class CategoryController {
	
	//Category.jsp  - addCategory, deleteCategory,
	//showCategoryList,updateCategory,editCategor
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;
	

	//CURD Operations
	@RequestMapping(value = "/manage_category_create" , method=RequestMethod.POST)
	public ModelAndView createCategory(@ModelAttribute("id")String id, 
			@ModelAttribute("name")String name,@ModelAttribute("description")String description)
	{
		
		category.setid(id);
		category.setname(name);
		category.setdescription(description);
		
		ModelAndView mv = new ModelAndView("Redirect:manage_category_create");
		
		if (categoryDAO.save(category))
		{
			mv.addObject("message", "Successfully created the category");
		}
		else
		{
			mv.addObject("message", "Not able to create Category.  Pl contact Administrator");
		}
		
		return mv;
		
	}
	
	
	
	
	
	
	@GetMapping("/manage_category_delete/{id}")
	public ModelAndView deleteCategory(@PathVariable("id") String id)
	{
		ModelAndView mv = new ModelAndView("/Admin/AdminHome");
		
		if(categoryDAO.delete(id))
		{
			mv.addObject("message", "Successfully delete the category");
		}
		else
		{
			mv.addObject("message", "Note able delete the category pl contact administrator");
		}
		return mv;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
