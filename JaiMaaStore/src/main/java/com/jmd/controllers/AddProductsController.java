package com.jmd.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AddProductsController {

	@Autowired
	AddProductRepository apr;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/FetchProduct", method = RequestMethod.GET)
	public String fetchProduct(Model m) {
		m.addAttribute("addproductbo", new Products());
		return "AddProduct";
	}

	@RequestMapping(value = "/AddProducts", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute(value = "addproductbo") Products addproductbo, Model m) {
		apr.save(addproductbo);
		return "Successfull";
	}

	@RequestMapping(value = "/DeleteProduct", method = RequestMethod.GET)
	public String deleteProduct(Model m) {
		m.addAttribute("removeproductbo", new Products());
		return "RemoveProduct";
	}

	@RequestMapping(value = "/Removeproduct", method = RequestMethod.POST)
	public String removeProduct(@ModelAttribute(value = "removeproductbo") Products removeproductbo, Model m) {
		apr.delete((long) removeproductbo.getId());
		return "Successfull";
	}

	@RequestMapping(value = "/SearchProducts", method = RequestMethod.GET)
	public String searchProduct(Model m) {
		m.addAttribute("searchproductbo", new Products());
		return "SearchProduct";
	}
	
	@RequestMapping(value = "/Searchproduct", method = RequestMethod.POST)
	public String search(@ModelAttribute(value = "searchproductbo") Products searchproductbo, Model m) {
		m.addAttribute("searchproductbo", new Products());
		List<Products> lt= apr.findById(searchproductbo.getId());
		for(Products pro:lt)
		{
			System.out.println(pro.getProductname()+""+pro.getProductprice());
		
		
		m.addAttribute("id",pro.getId());
		m.addAttribute("name",pro.getProductname());
		m.addAttribute("price",pro.getProductprice());
		m.addAttribute("quantity",pro.getProductquantity());
		}
		return "DisplayAllProducts";
	}
	
}
