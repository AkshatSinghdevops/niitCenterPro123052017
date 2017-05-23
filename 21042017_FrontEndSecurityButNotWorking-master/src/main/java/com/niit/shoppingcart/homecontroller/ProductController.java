package com.niit.shoppingcart.homecontroller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;
import com.niit.shoppingcart.util.FileUtil;
import com.niit.shoppingcart.util.Util;

@Controller
public class ProductController {
	
	
	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private Product product;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	
	@Autowired
	private Category category;
	

	@Autowired
	private SupplierDAO supplierDAO;
	
	
	@Autowired
	private Supplier supplier;	 
	
	
	private String path="D://akshat_project_files//21042017_FrontEndSecurityButNotWorking-master//src//main//webapp//resources//images";

	
		

	
 	@RequestMapping(value = "/manage_products", method = RequestMethod.GET)
	public String listProducts(Model model) {
		//log.debug("Starting of the method listProducts");
		model.addAttribute("product", new Product());
		/*model.addAttribute("category", new Category());
		model.addAttribute("supplier", new Supplier());*/
		model.addAttribute("productList", this.productDAO.list());
		/*model.addAttribute("categoryList", this.categoryDAO.list());
		model.addAttribute("supplierList", this.supplierDAO.list());*/
		model.addAttribute("isAdminClickedProducts", "true");
		//log.debug("Ending of the method listProducts");
		return "/Admin/Product";
	}

 	@RequestMapping(value = "/add_Product_Value" , method = {RequestMethod.POST})
	public String addProduct(@Valid @ModelAttribute("product") Product product,BindingResult result,
			HttpServletRequest request,@RequestParam String action ,Model model)
	{
		/*log.debug("The Starting  of Add Method");
		log.info("the product id is"+product.getId());
		log.info("the product id is"+product.getName());
		log.info("the product id is"+product.getDescription());
		log.info("the product id is"+product.getCategory_id());
		log.info("the product id is"+product.getSupplier_id());
		log.info("the product id is"+product.getFile());
		*/
 		 List<Category> categoryList=	categoryDAO.list();
 		List<Supplier> supplierList  = supplierDAO.list();
		
		if (result.hasErrors()) {
			model.addAttribute("product", product);
			model.addAttribute("products", productDAO.list());
			System.out.println("Found Errors in inputs");
			return "/Admin";
		}
		
		if(action.equals("save")){
			System.out.println("pcat"+product.getCategory_id());
			System.out.println("pdis"+product.getDescription());
			System.out.println("pid"+product.getId());
			
			
			
			productDAO.save(product);
			
			MultipartFile file = product.getFile();
			String originalFile = file.getOriginalFilename();

			String path = request.getSession().getServletContext().getRealPath("resources/images/");
			System.out.println("File path is " + path);
			String filename = path + "\\" + product.getId() + ".jpg";
			System.out.println("File path is " + path);

			try {
				byte image[] = product.getFile().getBytes();
				BufferedOutputStream bof = new BufferedOutputStream(new FileOutputStream(filename));
				bof.write(image);
				bof.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}else {
			productDAO.update(product);
			
			MultipartFile file = product.getFile();
			String originalFile = file.getOriginalFilename();

			String path = request.getSession().getServletContext().getRealPath("resources/images/");
			System.out.println("File path is " + path);
			String filename = path + "\\" + product.getId() + ".jpg";
			System.out.println("File path is " + path);

			try {
				byte image[] = product.getFile().getBytes();
				BufferedOutputStream bof = new BufferedOutputStream(new FileOutputStream(filename));
				bof.write(image);
				bof.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
		model.addAttribute("product", product);
		model.addAttribute("productList", productDAO.list());
		model.addAttribute("category", category);
		model.addAttribute("categoryList", categoryDAO.list());
		model.addAttribute("supplier", supplier);
		model.addAttribute("supplierList", supplierDAO.list());
		model.addAttribute("category.name", categoryDAO.getCategoryById("id"));
		model.addAttribute("isAdminClickedproducts", true);		
	return "/Admin/AdminHome";
	}
	
	
	@GetMapping("/manage_product_delete/{id}")
	public ModelAndView deleteProduct(@PathVariable("id") String id)
	{
		ModelAndView mv = new ModelAndView("forward:/manage_Product");
		
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

	@RequestMapping("manage_product_edit/{ID}")
	public String editProduct(@PathVariable("id") String id, Model model) {
		// productDAO.saveOrUpdate(product);
		//log.debug(" Starting of the method editProduct");

		product = productDAO.get(id);
		//model.addAttribute("product", product);
		//log.debug(" End of the method editProduct");
		return "forward:/manage_products";
	}
	


}
