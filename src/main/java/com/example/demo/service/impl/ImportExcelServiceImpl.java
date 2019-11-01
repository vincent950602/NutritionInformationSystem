package com.example.demo.service.impl;

import com.example.demo.entity.MaterialRecipe;
import com.example.demo.repository.MaterialRecipeRepository;
import com.example.demo.repository.MaterialRepository;
import com.example.demo.repository.RecipeRepository;
import com.example.demo.service.ImportExcelService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;

@Service
@Slf4j
public class ImportExcelServiceImpl implements ImportExcelService  {

    @Autowired
    MaterialRecipeRepository materialRecipeRepository;
    @Autowired
    MaterialRepository materialRepository;

    @Override
    public boolean batchImport(String fileName)  throws Exception{
        boolean notNull = false;
//        List<Recipe> recipeLists = new ArrayList<>();
//        List<Material> materialLists = new ArrayList<>();
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            log.info("上传文件格式不正确");
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = new FileInputStream(fileName);
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);//0表示第一个sheet
        if(sheet!=null){
            notNull = true;
        }
        MaterialRecipe recipe;
        for (int r = 1; r <= sheet.getLastRowNum(); r++) {//r = 1 表示从第二行开始循环 如果你的第二行开始是数据
            Row row = sheet.getRow(r);//通过sheet表单对象得到 行对象
            if (row == null){
                continue;
            }
            //sheet.getLastRowNum() 的值是 10，所以Excel表中的数据至少是10条；不然报错 NullPointerException
            recipe = new MaterialRecipe();

            row.getCell(0).setCellType(CellType.STRING);//

            String menu_type = row.getCell(0).getStringCellValue();//得到每一行第1个单元格的值
            if(menu_type==null || menu_type.isEmpty()){
                log.info("导入失败(第"+(r+1)+"行, menu_type未填写)");
            }

            row.getCell(1).setCellType(CellType.STRING);//
            String menu_code = row.getCell(1).getStringCellValue();//得到每一行第2个单元格的值
            if(menu_code==null || menu_code.isEmpty()){
                log.info("导入失败(第"+(r+1)+"行, menu_code未填写)");
            }

            row.getCell(2).setCellType(CellType.STRING);//
            String menu_name = row.getCell(2).getStringCellValue();//得到每一行第3个单元格的值
            if(menu_name==null || menu_name.isEmpty()){
                log.info("导入失败(第"+(r+1)+"行, menu_name未填写)");
            }

            row.getCell(3).setCellType(CellType.STRING);//
            String material_name = row.getCell(3).getStringCellValue();//得到每一行第4个单元格的值
            if(material_name==null || material_name.isEmpty()){
                log.info("导入失败(第"+(r+1)+"行, material_name未填写)");
            }

            row.getCell(4).setCellType(CellType.STRING);//
            String material_weight = row.getCell(4).getStringCellValue();//得到每一行第5个单元格的值
            if(material_weight==null || material_weight.isEmpty()){
                log.info("导入失败(第"+(r+1)+"行, material_weight未填写)");
            }


            //完整的循环一次 就组成了一个对象
            recipe.setMenuType(menu_type);
            recipe.setMenuCode(menu_code);
            recipe.setMenuName(menu_name);
            recipe.setMaterialName(material_name);
            recipe.setMaterialWeight(material_weight);
            recipe.setCreateTime(new Date());
            recipe.setUpdateTime(new Date());
            materialRecipeRepository.save(recipe);

//            materialLists.add();
        }
//        for (Recipe recipeList : recipeLists) {
//            String menutype = recipeList.getMenuType();
//
//            if (menutype != null) {
//                System.out.println(menutype);
//            } else {
//                System.out.println(" 没有更新");
//            }
//        }
        return notNull;
    }

}
