package com.example.demo.controller;


import com.example.demo.service.ImportExcelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class ImportExcelController {

    @Autowired
    ImportExcelService importExcelService;

    @RequestMapping(value = "/import")
    public String exImport() {
        String fileName = "/Users/guodi/Documents/Bookone.xlsx";
//        String fileName = "/Users/guodi/Documents/膳食计划/食材价格单.xlsx";
        try {
            boolean flag = importExcelService.batchImport(fileName);
            System.out.print(flag);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "login";
    }


}
