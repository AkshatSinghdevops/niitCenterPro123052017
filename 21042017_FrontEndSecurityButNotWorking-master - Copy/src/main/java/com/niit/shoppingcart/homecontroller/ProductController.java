package com.niit.shoppingcart.homecontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;

@Controller
public class ProductController {
	
	
	@Autowired
	private Product product;
	
	@Autowired
	private ProductDAO productDAO;
	
	
	@RequestMapping("/product_create")
	public ModelAndView createProduct(@ModelAttribute("id")String id, 
			@ModelAttribute("name")String name, 
			@ModelAttribute("description")String description,
			@ModelAttribute("price")String  price,@ModelAttribute("image")MultipartFile image,
			@ModelAttribute("category_id")String category_id,@ModelAttribute("supplier_id")
	        String supplier_id
			)
			
	{ 
		product.setId(id);
		product.setName(name);
		product.setDescription(description);
	    product.setPrice(price);
		product.setImage(image);
		product.setCategory_id(category_id);
        product.setSupplier_id(supplier_id);		
		ModelAndView mv = new ModelAndView("redirect:ManageProduct");
		
		if (productDAO.save(product))
		{
			mv.addObject("message", "Successfully created new product");
		}
		else
		{
			mv.addObject("message", "Not able to create product.  Pl contact Administrator");
		}
		
		return mv;
		
		
	
	}
	

	@GetMapping("/manage_product_delete/{id}")
	public ModelAndView deleteProduct(@PathVariable("id") String id)
	{
		ModelAndView mv = new ModelAndView("/Admin/AdminHome");
		
		if(productDAO.delete(id))
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
