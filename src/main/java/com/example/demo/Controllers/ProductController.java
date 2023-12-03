package com.example.demo.Controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Classes.Product;
import com.example.demo.Repositories.ProductRepo;

@Controller
@RestController
public class ProductController {
	
	public ProductRepo productRepo;

	@GetMapping(path = "/products")
	public @ResponseBody Iterable<Product> getproducts()
	{
		return productRepo.findAll();
	}
	
	@PostMapping(path = "/getproduct")
	public String postproducts()
	{
		return "";
	}
}
