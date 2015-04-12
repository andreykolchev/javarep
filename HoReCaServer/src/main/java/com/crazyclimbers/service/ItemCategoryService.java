package com.crazyclimbers.service;

import com.crazyclimbers.model.ItemCategory;
import com.crazyclimbers.repository.ItemCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ItemCategoryService {

    @Autowired
    ItemCategoryRepository itemCategoryRepository;

    public List<ItemCategory> findAll() {
        return itemCategoryRepository.findAll();
    }


}
