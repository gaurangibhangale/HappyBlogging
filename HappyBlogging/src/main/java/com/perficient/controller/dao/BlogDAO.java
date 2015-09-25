package com.perficient.controller.dao;

import java.util.List;

import com.perficient.controller.model.Blog;

public interface BlogDAO {

	public void addBlog(Blog p);
	public void updateBlog(Blog p);
	public List<Blog> listBlogs();
	public Blog getBlogById(int id);
	public void removeBlog(int id);
}
