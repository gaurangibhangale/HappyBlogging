package com.perficient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.perficient.controller.model.Blog;
import com.perficient.controller.service.BlogService;

@Controller
public class BlogController {
	
	private BlogService blogService;
	
	@Autowired(required=true)
	@Qualifier(value="blogService")
	public void setBlogService(BlogService ps){
		this.blogService = ps;
	}
	
	@RequestMapping(value = "/blogs", method = RequestMethod.GET)
	public String listBlogs(Model model) {
		
		model.addAttribute("blog", new Blog());
		model.addAttribute("listBlogs", this.blogService.listBlogs());
		return "blog";
	}
	
	//Add n update blog
	@RequestMapping(value= "/blog/add", method = RequestMethod.POST)
	public String addBlog(@ModelAttribute("blog") Blog p){
		
		if(p.getId() == 0){
			this.blogService.addBlog(p);
		}else{
			
			this.blogService.updateBlog(p);
		}
		
		return "redirect:/blogs";
		
	}
	
	//delete
	@RequestMapping("/remove/{id}")
    public String removeBlog(@PathVariable("id") int id){
		
        this.blogService.removeBlog(id);
        return "redirect:/blogs";
    }
 
	//edit
    @RequestMapping("/edit/{id}")
    public String editBlog(@PathVariable("id") int id, Model model){
        model.addAttribute("blog", this.blogService.getBlogById(id));
        model.addAttribute("listBlogs", this.blogService.listBlogs());
        return "blog";
    }
	
}
