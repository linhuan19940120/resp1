package com.huan.controller;

import com.huan.dao.ItemMappper;
import com.huan.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ItemController {
    @Autowired
    private ItemMappper mappper;

    @RequestMapping("/queryItemList")
    @ResponseBody
    public  List<Item> queryItemList(){
        List<Item> items=mappper.queryItemList();
        return items;
    }
}
