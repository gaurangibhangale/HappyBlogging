package com.perficient.controller.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.perficient.controller.model.Blog;

@Repository
public class BlogDAOImpl implements BlogDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(BlogDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addBlog(Blog p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Blog saved successfully, Blog Details="+p);
	}

	@Override
	public void updateBlog(Blog p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Blog updated successfully, Blog Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Blog> listBlogs() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Blog> blogList = session.createQuery("from Blog").list();
		for(Blog p : blogList){
			logger.info("Blog List::"+p);
		}
		return blogList;
	}

	@Override
	public Blog getBlogById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Blog p = (Blog) session.load(Blog.class, new Integer(id));
		logger.info("Blog loaded successfully, Blog details="+p);
		return p;
	}

	@Override
	public void removeBlog(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Blog p = (Blog) session.load(Blog.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Blog deleted successfully, blog details="+p);
	}

}
