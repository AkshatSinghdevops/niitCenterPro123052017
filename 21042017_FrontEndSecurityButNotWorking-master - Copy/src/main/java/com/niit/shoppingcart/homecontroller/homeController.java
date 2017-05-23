package com.niit.shoppingcart.homecontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;
import com.niit.shoppingcart.domain.User;

@Controller
public class homeController {
	

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private User user;
	
	@Autowired
	private Category category; 
	
	@Autowired
	private CategoryDAO categoryDAO;;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private Supplier supplier;
	
	@Autowired
	private SupplierDAO  supplierDAO;
	
	@Autowired
	private Product product;
	
	@Autowired
	private ProductDAO productDAO;
	

	
	
	@RequestMapping(value = {("/"),("/index")})
	public ModelAndView showHomePage()
	{
		
		//Specifying which page you have navigateion
		ModelAndView mv = new ModelAndView("/index");
		 List<Category> categoryList=	categoryDAO.list();
		  mv.addObject("categoryList", categoryList);
		  mv.addObject("category", category);//To access category domain object in category.jsp
		  
		  List<Supplier> supplierList  = supplierDAO.list();
			mv.addObject("supplierList" , supplierList);
			mv.addObject("supplier" , supplier);
			
		 List<Product> productList =  productDAO.list();
			 mv.addObject("productList",productList);
			 mv.addObject("product",product);
		//Specify what data you have to carry to home page
		
		mv.addObject("msg", "WELCOME TO SHOPPING CART");
		
		return mv;
	}
	@RequestMapping("/Login")
	public ModelAndView showLoginPage()
	{
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("msg", "  WELCOME TO LOGIN PAGE");
		mv.addObject("isUserClickedLogin","true");
		return mv;
	}

	@RequestMapping("/Registration")
	public ModelAndView showRegistrationPage()
	{
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("msg", "  WELCOME TO Registration page ");
		mv.addObject("isUserClickedRegistration","true");
		mv.addObject("user",user);
		return mv;
	}
	
	@RequestMapping("/Contact")
	public ModelAndView showContactPage()
	{
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("msg", " Hey Hello Brother , WELCOME TO LOGIN PAGE");
		mv.addObject("isUserClickedContact","true");
		return mv;
	}
	@RequestMapping("/Menu")
	public ModelAndView showMenuPage()
	{
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("msg", " Hey Hello Brother , WELCOME TO LOGIN PAGE");
		mv.addObject("isUserClickedMenu","true");
		return mv;
	}
	

/*
	@RequestMapping("/validate")
	public ModelAndView validateCredentials(@RequestParam(value="id") String id,@RequestParam(value="password") String pwd)
	{

		
		//Actually you have get the data from DB
		//Tempororily  -user->niit password =niit@123
		
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("isUserLoggedIn", "false");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if( userDAO.validate(id, pwd)==true)
		
		{
			//Createntials are correct
			mv.addObject("isUserLoggedIn", "true");
			
			user = userDAO.getUser(id);
			
			if(user.getRole().equals("Role_Admin"))
			{   
				mv.addObject("isAdmin", "true");
				mv.addObject("role", "Admin");
			}
			else
			{
				mv.addObject("isAdmin", "false");
				mv.addObject("role", "User");
			}
			
			mv.addObject("successMessage", "Valid Credentials");
			session.setAttribute("loginMessage", "Welcome :" +id);
		}
		else
		{
			mv.addObject("errorMessage", "InValid Credentials...please try again");
		}
		
		return mv;
		
		
	}
	*/
	@RequestMapping("/logout")
	public ModelAndView showlogout()
	{
		ModelAndView mv = new ModelAndView("/index");
		session.removeAttribute("loginMessage");
		return mv;
				
	}
	
	@RequestMapping("/Mycart")
	public ModelAndView showMycart()
	{
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("isUserClickedMycart", "true");
		return mv;
	}
	
	 
}
