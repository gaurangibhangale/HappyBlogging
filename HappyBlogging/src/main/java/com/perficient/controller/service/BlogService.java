package com.perficient.controller.service;

import java.util.List;

import com.perficient.controller.model.Blog;

public interface BlogService {

	public void addBlog(Blog p);
	public void updateBlog(Blog p);
	public List<Blog> listBlogs();
	public Blog getBlogById(int id);
	public void removeBlog(int id);
	
}
