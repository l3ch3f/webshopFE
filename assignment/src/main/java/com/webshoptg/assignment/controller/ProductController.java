package com.webshoptg.assignment.controller;

import com.webshoptg.assignment.model.product.ProductInfo;
import com.webshoptg.assignment.model.product.ProductSpecification;
import com.webshoptg.assignment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.charset.Charset;
import java.util.Optional;
import java.util.Random;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/{id}")
    public String viewProductDetailsPage(@PathVariable("id")Long id, Model model){
        Optional<ProductInfo> product = service.findById(id);
        ProductSpecification specs = product.get().getProductSpecification();
        model.addAttribute("product", product.get());
        model.addAttribute("specs", specs);

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        model.addAttribute("new_token",generatedString);
        return "product";
    }

}
