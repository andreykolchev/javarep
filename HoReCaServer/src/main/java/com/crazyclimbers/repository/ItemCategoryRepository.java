package com.crazyclimbers.repository;

import com.crazyclimbers.model.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemCategoryRepository extends JpaRepository<ItemCategory, Long> {

    List<ItemCategory> findAll();

}
