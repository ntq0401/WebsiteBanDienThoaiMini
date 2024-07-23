package com.demo.controller;

import com.demo.model.Account;
import com.demo.model.Category;
import com.demo.model.Product;
import com.demo.repo.AccountRepo;
import com.demo.repo.CategoryRepo;
import com.demo.repo.ProductRepo;
import jakarta.servlet.ServletContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    AccountRepo accountRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    ServletContext app;
    @ModelAttribute("listCategory")
    public List<Category> getListCate() {
        return categoryRepo.findAll();
    }
    //  Category
    @GetMapping("/admin")
    public String listCategory(Model model){
        model.addAttribute("listCate",categoryRepo.findAll());
        return "admin/category/list";
    }

    @GetMapping("/admin/category/create")
    public String createCategory(Model model){
        model.addAttribute("ct",new Category());
        return "admin/category/form";
    }

    @PostMapping("/admin/category/create")
    public String createCategory(@Valid @ModelAttribute("ct") Category category, BindingResult rs){
        if(!rs.hasErrors()){
            categoryRepo.save(category);
            return "redirect:/admin";
        }
        return "admin/category/form";
    }
    @GetMapping("/admin/category/update/{id}")
    public String editCategory(@PathVariable("id") String id, Model model){
        model.addAttribute("ct",categoryRepo.findById(id).orElse(null));
        model.addAttribute("isUpdate",true);
        return "admin/category/form";
    }
    @PostMapping("/admin/category/update/{id}")
    public String updateCategory(@PathVariable("id") String id, @ModelAttribute("ct") Category category){
            category.setId(id);
            categoryRepo.save(category);
            return "redirect:/admin";
    }
    //  Product
    @GetMapping("/admin/product")
    public String listProduct(Model model){
        model.addAttribute("listProduct",productRepo.findAll());
        return "admin/product/list";
    }

    @GetMapping("/admin/product/create")
    public String createProduct(Model model){
        model.addAttribute("p",new Product());
        return "admin/product/form";
    }
    @PostMapping("/admin/product/create")
    public String createProduct(@Valid @ModelAttribute("p") Product product, BindingResult rs){
        if(!rs.hasErrors()){
            productRepo.save(product);
            return "redirect:/admin/product";
        }
        return "admin/product/form";
    }

    @GetMapping("/admin/product/update/{id}")
    public String editProduct(@PathVariable("id") int id,Model model){
        model.addAttribute("p",productRepo.findById(id).orElse(null));
        model.addAttribute("isUpdate",true);
        return "admin/product/form";
    }
    @PostMapping("/admin/product/update/{id}")
    public String updateProduct(@PathVariable("id") int id, @ModelAttribute("p") Product product){
        product.setId(id);
        productRepo.save(product);
        return "redirect:/admin/product";
    }
    //  Account
    @GetMapping("/admin/account")
    public String listAccount(Model model){
        model.addAttribute("listAccount",accountRepo.findAll());
        return "admin/account/list";
    }

    @GetMapping("/admin/account/create")
    public String createAccount(Model model){
        model.addAttribute("a",new Account());
        return "admin/account/form";
    }
    @PostMapping("/admin/account/create")
    public String createAccount(@Valid @ModelAttribute("a") Account account, BindingResult rs){
        if(!rs.hasErrors()){
            accountRepo.save(account);
            return "redirect:/admin/account";
        }
        return "admin/account/form";
    }
    @GetMapping("/admin/account/update/{username}")
    public String editAccount(@PathVariable("username") String username, Model model){
        model.addAttribute("a",accountRepo.findById(username).orElse(null));
        model.addAttribute("isUpdate",true);
        return "admin/account/form";
    }
    @PostMapping("/admin/account/update/{username}")
    public String updateAccount(@PathVariable("username") String username, @ModelAttribute("a") Account account){
        account.setUsername(username);
        accountRepo.save(account);
        return "redirect:/admin/account";
    }
}
