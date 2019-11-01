package com.example.demo.service.impl;

import com.example.demo.entity.CommonMenu;
import com.example.demo.entity.QRecipes;
import com.example.demo.entity.Recipes;
import com.example.demo.repository.CommonMenuRepository;
import com.example.demo.repository.RecipeRepository;
import com.example.demo.service.MaterialRecipeService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class MaterialRecipeServiceImpl implements MaterialRecipeService {

    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    JPAQueryFactory jpaQueryFactory;
    @Autowired
    CommonMenuRepository commonMenuRepository;


    @Override
    public int initMaterialRecipe() {
        log.info("初始化饮食计划开始...");

        String[] menuType = {"1","2","3"};

        for(int i = 0; i <= menuType.length; i++){

            //第一步：生成早餐的食物
            //查询食物未使用的是次数：0为未使用，1为已使用
            List<Recipes> recipesList = recipeRepository.findAllByMenuType(menuType[i]);
            //如果为空先清除
            if(recipesList == null || recipesList.isEmpty()){
                //先清除已使用标签1为0 操作update数据

                //再查一下未使用的
                recipesList = recipeRepository.findAllByMenuType(menuType[i]);
            }

            if(recipesList != null || !recipesList.isEmpty()){//不为空的情况下

                //修改标签0 变为1 表示已使用
                Recipes recipes = recipesList.get(0);
                recipes.setUseTimes("1");
                recipeRepository.saveAndFlush(recipes);

                //取第一个放到存到菜谱计划表中
                CommonMenu commonMenu = new CommonMenu();
                commonMenu.setCreateTime(new Date());
                commonMenu.setMenuCode(recipesList.get(0).getMenuCode());
                commonMenu.setMenuName(recipesList.get(0).getMenuName());
                commonMenu.setMenuZhw("早餐");
                //commonMenu.setMenuTime(new Date());生成七天的应该设置时间标签
                commonMenuRepository.save(commonMenu);
            }

            for(int j = 0; j<= recipesList.size();  ){

            }

        }
        return 0;
    }

    public Recipes getZC01 (String code){
        QRecipes recipes = QRecipes.recipes;
        Recipes value = jpaQueryFactory.selectFrom(recipes).where(
            recipes.menuType.eq(code)
        ).fetchOne();
        return value;
    }
}
