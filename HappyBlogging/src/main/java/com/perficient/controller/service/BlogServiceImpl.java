package com.perficient.controller.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.perficient.controller.dao.BlogDAO;
import com.perficient.controller.model.Blog;

@Service
public class BlogServiceImpl implements BlogService {
	
	private BlogDAO blogDAO;

	public void setBlogDAO(BlogDAO blogDAO) {
		this.blogDAO = blogDAO;
	}

	@Override
	@Transactional
	public void addBlog(Blog p) {
		this.blogDAO.addBlog(p);
	}

	@Override
	@Transactional
	public void updateBlog(Blog p) {
		this.blogDAO.updateBlog(p);
	}

	@Override
	@Transactional
	public List<Blog> listBlogs() {
		return this.blogDAO.listBlogs();
	}

	@Override
	@Transactional
	public Blog getBlogById(int id) {
		return this.blogDAO.getBlogById(id);
	}

	@Override
	@Transactional
	public void removeBlog(int id) {
		this.blogDAO.removeBlog(id);
	}

}
