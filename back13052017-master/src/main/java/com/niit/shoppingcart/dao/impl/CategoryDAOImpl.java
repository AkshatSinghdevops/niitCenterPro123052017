package com.niit.shoppingcart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

@Transactional
@Repository("categoryDAO")
public class CategoryDAOImpl  implements CategoryDAO{
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	//CategoryDAOImpl c = new CategoryDAOImpl
	
	
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	
	

	public List<Category> list() {
		//select * from category  -SQL Query - mention the table name
		//from Category  -> HQL -mention Domain class name not table name
		
		//convert the hibernate query into db specific language
	return	sessionFactory.getCurrentSession().createQuery("from Category").list();
		
	}

	public boolean save(Category category) {
		try
		{
		sessionFactory.getCurrentSession().save(category);
		return true;
		} catch(Exception e)
		{
			e.printStackTrace(); //it will print the error in the console - similar to SOP
			          //package, class, method line number from which place you are calling
			return false;
		}
		
	}

	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}

	public boolean delete(String id) {
		try {
			sessionFactory.getCurrentSession().delete(getCategoryByID(id));
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean delete(Category category) {
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}

	public Category getCategoryByID(String id) {
		//select * from Category where id ='mobile'
	//  return	(Category)  sessionFactory.getCurrentSession().get(Category.class, id);
	  
	  return  (Category) sessionFactory.getCurrentSession().createQuery("from Category where id = '"+id + "'").uniqueResult();
		
	}

	/*public Category getCategoryByName(String name) {
		  
		  //return  (Category) sessionFactory.getCurrentSession().createQuery("from Category where name = '"+name + "'").list().get(0);
		return 	(Category)  sessionFactory.getCurrentSession().createQuery("from Category where name = ?").setString(0, name).uniqueResult();


	}*/




	
	
	
	//===============================================================================
	
public Category getCategoryById(String id) {
		
		//get method get the date from user table based on primary key i.e., id
		// and set it to Category class
		//like select * from category where id = ?
	  return 	(Category)  sessionFactory.getCurrentSession().get(Category.class, id);
		
	}
	
	
	public Category getCategoryByName(String name) {
		
		//Since name is not a primary key, we cannot use the procedure used in getCategoryById(id).
		//We write query as follow.
		return 	(Category)  sessionFactory.getCurrentSession().createQuery("from Category where name = ?").setString(0, name).uniqueResult();
		/*
		 * return 	(Category)  sessionFactory.getCurrentSession().createQuery("from Category where name = ?").setString(0, name).uniqueResult(); is same as
		 * 
		 * Query query = getCurrentSession().createQuery("from Category where name = ?");
		 * query.setString(0,name);
		 * query.uniqueResult();
		 */
	
	}




	public Category get(String id) {
		// TODO Auto-generated method stub
		return (Category)  sessionFactory.getCurrentSession().createQuery("from Category where id = ?").setString(0, id).uniqueResult();
	}




	public boolean saveOrUpdate(Category category) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}