package com.example.finalexamsetc_seng.controller;

import com.example.finalexamsetc_seng.entities.category;
import com.example.finalexamsetc_seng.entities.items;
import com.example.finalexamsetc_seng.entities.sales;
import com.example.finalexamsetc_seng.repository.CategoryRepository;
import com.example.finalexamsetc_seng.entities.SalesSummary;
import com.example.finalexamsetc_seng.repository.ItemRepository;
import com.example.finalexamsetc_seng.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SessionAttributes({"qty0"})
@Controller
public class AppController {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    SalesRepository salesRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/")
    public String showIndex(Model model) {

        List<items> itemList = itemRepository.findAll();
        List<sales> salesList = salesRepository.findAll();
        sales sale = new sales();
        System.out.println("Number of items fetched: " + itemList.size());
        model.addAttribute("itemList", itemList);
        model.addAttribute("sales", sale);
        model.addAttribute("salesList", salesList);


        List<category> categories = categoryRepository.findAll();
        List<SalesSummary> salesSummaries = new ArrayList<>();

        for (category category : categories) {
            Double totalSales = salesRepository.getTotalSalesForCategory(category.getCatCode());
            salesSummaries.add(new SalesSummary(category.getCatCode(), category.getCatCode(), totalSales));
        }

        model.addAttribute("salesSummaries", salesSummaries);



        return "index";
    }

    @PostMapping("/save")
    public String saveData(@ModelAttribute("sales") sales sale) {

        sale.setDate(new Date());
        salesRepository.save(sale);

        return "redirect:/";
    }

    @GetMapping(path="/edit")
    public String showEdit(@RequestParam("id") Long id,
                           @RequestParam("recno") String recno,
                           Model model){

        sales sale = salesRepository.findSaleById(id);
        model.addAttribute("sale",sale);
        model.addAttribute("id", id);
        model.addAttribute("recno", recno);
        return "editReceipt";
    }

    @PostMapping("/edit")
    public String editSale(@ModelAttribute sales sale,
                           @RequestParam(name = "itemType") String itemType,
                           @RequestParam(name = "quantity") int quantity) {

        sales originalSale = salesRepository.findById(sale.getId()).orElse(null);

        if (originalSale != null) {

            originalSale.setIcode(itemType);
            originalSale.setQty(quantity);


            salesRepository.save(originalSale);
        }

        return "redirect:/";
    }

    @PostMapping("/deleteSale")
    @Transactional
    public String deleteSale(@RequestParam Long id) {

        salesRepository.deleteById(id);

        return "redirect:/";
    }

}
