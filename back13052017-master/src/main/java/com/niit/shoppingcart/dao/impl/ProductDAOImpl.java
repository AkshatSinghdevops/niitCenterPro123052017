package com.niit.shoppingcart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;



@Transactional
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<Product> list() {
		return	sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	public boolean save(Product product) {
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}

	public boolean update(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(String id) {
		try {
			sessionFactory.getCurrentSession().delete(getProductById(id));
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	

	public boolean saveOrUpdate(Product product) {
		// TODO Auto-generated method stub
		return false;
	}
//======================================================================================
	
	public Product getProductById(String id) {
		// get method get the date from user table based on primary key i.e., id
		// and set it to User class
		// like select * from user where id = ?
		return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
	}

	public Product getProductByName(String name) {
		return (Product) sessionFactory.getCurrentSession().createQuery("from Product where name = ?")
				.setString(0, name).uniqueResult();
	}

	public List<Product> getAllProductsByCategoryId(String categoryId) {
		
		
		return sessionFactory.getCurrentSession().createQuery("from Product where category_Id=?").
		setString(0, categoryId).
		 list();

		// TODO Auto-generated method stub
	}

	
	public List<Product> getAllProductsBySupplierId(String supplierId) {
		return sessionFactory.getCurrentSession().createQuery("from Product where supplier_Id = ?").setString(0, supplierId).list();
	}

	public Product get(String id) {
		return (Product) sessionFactory.getCurrentSession().createQuery("from Product where id = ?")
				.setString(0, id).uniqueResult();
	}

	public List<Product> getSimilarProducts(String search_string) {
		
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

}
