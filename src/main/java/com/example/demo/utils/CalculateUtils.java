package com.example.demo.utils;

import com.example.demo.entity.MaterialRecipe;
import com.example.demo.repository.MaterialRecipeRepository;
import com.example.demo.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CalculateUtils {

    @Autowired
    MaterialRecipeRepository materialRecipeRepository;
    @Autowired
    MaterialRepository materialRepository;


    public int getPrice(String menuCode){
        //先通过code查询到菜谱的材料
        List<MaterialRecipe> materialRecipeList = materialRecipeRepository.findByMenuCode(menuCode);

        int cost = 0;
        for(int i=0; i<=materialRecipeList.size(); i++){
            String  materialCode = materialRecipeList.get(i).getMaterialCode();
            Integer  price = materialRepository.findByMaterialCode(materialCode);

            cost = Integer.valueOf(materialRecipeList.get(i).getMaterialWeight())*price;
            cost +=cost;
        }

        return cost;
    }

//    public double switchValue(String materialCode){
//
//        switch(materialCode){
//            case "Z001":
//                return 3;
//            case "Z002":
//                return 4.5;
//            case "Z003":
//                return 4.5;
//            case "Z004":
//                return 4.5;
//            default:
//                return  0;
//        }
//    }

}
