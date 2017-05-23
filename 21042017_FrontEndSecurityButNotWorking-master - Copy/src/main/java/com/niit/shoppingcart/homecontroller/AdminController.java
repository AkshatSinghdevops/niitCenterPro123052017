 package com.niit.shoppingcart.homecontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;


@Controller
@RequestMapping("/Admin")
public class AdminController {


	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Category  category;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@Autowired
	Product product;
	
	@Autowired
	ProductDAO productDAO;
	@Autowired
	HttpSession session;
	

	@RequestMapping("/manage_categories")
	public ModelAndView manageCategories()
	{   session.getAttribute("loggedInUser");
		System.out.println("manageCategories");
		ModelAndView mv = new ModelAndView("/Admin/AdminHome");
		mv.addObject("isUserCategoryPage","true");
		//get the categories from db.
		
	  List<Category> categoryList=	categoryDAO.list();
	  mv.addObject("categoryList", categoryList);
	  mv.addObject("category", category);//To access category domain object in category.jsp
		
		return mv;
		
	}
	
	@RequestMapping("/manage_Supplier")
	public ModelAndView manageSupplier()
	{
		System.out.println("Manage Suppplier");
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("isUserClickedSupplier",true);
		
		List<Supplier> supplierList  = supplierDAO.list();
		mv.addObject("supplierList" , supplierList);
		mv.addObject("supplier" , supplier);
		return mv;
	}
	
	@RequestMapping("/manage_Product")
	public ModelAndView manageProduct()
	{
		 System.out.println("manage product");
		 ModelAndView mv = new ModelAndView("/index");
		 mv.addObject("isUserClickedProduct","true");
		 
		 List<Product> productList =  productDAO.list();
		 mv.addObject("productList",productList);
		 mv.addObject("product",product);
		 
		 return mv;
	}
	
}
