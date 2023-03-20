package com.juaracoding.CSmaster.controller;/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author Farhan a.k.a Muhammad Farhan Kamil
Java Developer
Created On 20/03/2023 17:14
@Last Modified 20/03/2023 17:14
Version 1.0
*/

import com.juaracoding.CSmaster.configuration.OtherConfig;
import com.juaracoding.CSmaster.dto.CategoryDTO;
import com.juaracoding.CSmaster.dto.DivisiDTO;
import com.juaracoding.CSmaster.model.Complain;
import com.juaracoding.CSmaster.model.Product;
import com.juaracoding.CSmaster.service.CategoryService;
import com.juaracoding.CSmaster.service.ComplainService;
import com.juaracoding.CSmaster.service.DivisiService;
import com.juaracoding.CSmaster.service.ProductService;
import com.juaracoding.CSmaster.utils.MappingAttribute;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/report")
public class ReportController {

	private Map<String,Object> objectMapper = new HashMap<String,Object>();

	private String [] strExceptionArr = new String[2];

	private MappingAttribute mappingAttribute = new MappingAttribute();

	private ComplainService complainService;
	private DivisiService divisiService;
	private ProductService productService;

	@GetMapping("/v1/divisi/default")
	public String ListDivisiPage(Model model,WebRequest request)
	{
		if(OtherConfig.getFlagSessionValidation().equals("y"))
		{
			mappingAttribute.setAttribute(model,objectMapper,request);//untuk set session
			if(request.getAttribute("USR_ID",1)==null){
				return "redirect:/api/check/logout";
			}
		}
		Pageable pageable = PageRequest.of(0,5, Sort.by("idDivisi"));
		objectMapper = divisiService.findAllDivisi(pageable,request);
		mappingAttribute.setAttribute(model,objectMapper,request);

		model.addAttribute("divisi",new DivisiDTO());
		model.addAttribute("sortBy","idDivisi");
		model.addAttribute("currentPage",1);
		model.addAttribute("asc","asc");
		model.addAttribute("columnFirst","");
		model.addAttribute("valueFirst","");
		model.addAttribute("sizeComponent",5);
		return "/divisi/divisi";
	}

	@GetMapping("/v1/category/default")
	public String listCategoryPage(Model model, WebRequest request, CategoryService categoryService)
	{
		if(OtherConfig.getFlagSessionValidation().equals("y"))
		{
			mappingAttribute.setAttribute(model,objectMapper,request);//untuk set session
			if(request.getAttribute("USR_ID",1)==null){
				return "redirect:/api/check/logout";
			}
		}
		Pageable pageable = PageRequest.of(0,5, Sort.by("idCategory"));
		objectMapper = categoryService.findAllCategory(pageable,request);
		mappingAttribute.setAttribute(model,objectMapper,request);

		model.addAttribute("category",new CategoryDTO());
		model.addAttribute("sortBy","idCategory");
		model.addAttribute("currentPage",1);
		model.addAttribute("asc","asc");
		model.addAttribute("columnFirst","");
		model.addAttribute("valueFirst","");
		model.addAttribute("sizeComponent",5);
		return "/report/reportcategory";
	}
	@GetMapping("v1/complain/default")
	public String listComplainPage(Model model, WebRequest request, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {
		if (OtherConfig.getFlagSessionValidation().equals("y")) {
			mappingAttribute.setAttribute(model, objectMapper, request);//untuk set session
			if (request.getAttribute("USR_ID", 1) == null) {
				return "redirect:/api/check/logout";
			}
		}

		Page<Complain> complains = complainService.findAllComplain(page, size);

		model.addAttribute("complains", complains);
		model.addAttribute("currentPage", complains.getNumber() + 1);
		model.addAttribute("totalItems", complains.getTotalElements());
		model.addAttribute("totalPages", complains.getTotalPages());
		model.addAttribute("pageSize", size);
		model.addAttribute("complain", new Complain());

		return "/complain/list";
	}
	@GetMapping("/list")
	public String listProductPage(Model model, WebRequest request, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {
		if (OtherConfig.getFlagSessionValidation().equals("y")) {
			mappingAttribute.setAttribute(model, objectMapper, request);//untuk set session
			if (request.getAttribute("USR_ID", 1) == null) {
				return "redirect:/api/check/logout";
			}
		}

		Page<Product> products = productService.findAllProduct(page, size);

		model.addAttribute("products", products);
		model.addAttribute("currentPage", products.getNumber() + 1);
		model.addAttribute("totalItems", products.getTotalElements());
		model.addAttribute("totalPages", products.getTotalPages());
		model.addAttribute("pageSize", size);
		model.addAttribute("product", new Product());

		return "/product/list";
	}
}
