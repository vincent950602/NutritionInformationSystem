package com.example.demo.repository;

import com.example.demo.entity.Recipes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;


public interface RecipeRepository extends JpaRepository<Recipes,Integer >, QuerydslPredicateExecutor<Recipes> {

    @Query("select r from Recipes r")
    Page<Recipes> findList(Pageable pageable);

    @Query("select m.menuCode from Recipes m where menuCode = ?1")
    String findByMenuCode(String code);

    @Query("select r from Recipes r where r.menuType = ?1 and r.useTimes='0'")
    List<Recipes> findAllByMenuType(String menuType);

//    MaterialRecipe findByMenuCodeOrMenuName(String code);

//    void deleteByMenuCode(String code);
}
