package com.crazyclimbers.controller;


import com.crazyclimbers.model.ItemCategory;
import com.crazyclimbers.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping(value = "itemCategory/")
@RestController
public class ItemCategoryController {

    @Autowired
    ItemCategoryService itemCategoryService;

    @RequestMapping(method = RequestMethod.GET)
    public List<ItemCategory> readItemCategory() {
        return itemCategoryService.findAll();
    }

}