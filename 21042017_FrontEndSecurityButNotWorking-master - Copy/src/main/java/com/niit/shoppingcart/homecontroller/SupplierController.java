package com.niit.shoppingcart.homecontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;
@Controller
public class SupplierController {



	@Autowired
	private Supplier supplier;
	
	@Autowired
	private SupplierDAO supplierDAO;


	//CURD Operations
		@RequestMapping(value = "/manage_supplier_create" , method=RequestMethod.POST)
		public ModelAndView createSupplier(@ModelAttribute("id")String id, 
				@ModelAttribute("name")String name,@ModelAttribute("address")String address)
		{
			
			supplier.setId(id);
			supplier.setName(name);
			supplier.setAddress(address);
			
			ModelAndView mv = new ModelAndView("Redirect:manage_category_create");
			
			if (supplierDAO.save(supplier))
			{
				mv.addObject("message", "Successfully created the category");
			}
			else
			{
				mv.addObject("message", "Not able to create Category.  Pl contact Administrator");
			}
			
			return mv;
			
		}






	@GetMapping("/manage_supplier_delete/{id}")
	public ModelAndView deleteSupplier(@PathVariable("id") String id)
	{
		ModelAndView mv = new ModelAndView("/Admin/AdminHome");
		
		if(supplierDAO.delete(id))
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
