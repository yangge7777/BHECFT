package com.yang.controller;

import com.yang.bean.Tb_item_cat;
import com.yang.bean.Tb_item_catExample;
import com.yang.mapper.Tb_item_catMapper;
import com.yang.service.Tb_itemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 18/8/15.
 * ░░░░░░░░░░░░░░░░░░░░░░░░▄░░
 * ░░░░░░░░░▐█░░░░░░░░░░░▄▀▒▌░
 * ░░░░░░░░▐▀▒█░░░░░░░░▄▀▒▒▒▐
 * ░░░░░░░▐▄▀▒▒▀▀▀▀▄▄▄▀▒▒▒▒▒▐
 * ░░░░░▄▄▀▒░▒▒▒▒▒▒▒▒▒█▒▒▄█▒▐
 * ░░░▄▀▒▒▒░░░▒▒▒░░░▒▒▒▀██▀▒▌
 * ░░▐▒▒▒▄▄▒▒▒▒░░░▒▒▒▒▒▒▒▀▄▒▒
 * ░░▌░░▌█▀▒▒▒▒▒▄▀█▄▒▒▒▒▒▒▒█▒▐
 * ░▐░░░▒▒▒▒▒▒▒▒▌██▀▒▒░░░▒▒▒▀▄
 * ░▌░▒▄██▄▒▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒
 * ▀▒▀▐▄█▄█▌▄░▀▒▒░░░░░░░░░░▒▒▒
 * My Dear Taoism's Friend .Please SitDown.
 */
@Controller
@RequestMapping("/tb_item_descController")
public class Tb_item_descController {


    @Resource
    private Tb_itemService tb_itemServiceImpl;
    @Resource
    private Tb_item_catMapper tb_item_catMapper;
    @RequestMapping(value = "/item_descShow.do")
    @ResponseBody
    public  Map<String, Object> item_descShow(){
        Map<String, Object> map = new HashMap<>();
        Map<String, String> map1 = new HashMap<>();
        map.put("showdesc", tb_itemServiceImpl.select_Tb_item_catShow());
        for (String s : tb_itemServiceImpl.select_Tb_item_catShow().keySet()) {
            Tb_item_catExample example = new Tb_item_catExample();
            Tb_item_catExample.Criteria criteria =example.createCriteria();
            criteria.andIdEqualTo(Long.valueOf(s));
            List<Tb_item_cat> item_cats = tb_item_catMapper.selectByExample(example);
            for (Tb_item_cat item_cat : item_cats) {
                map1.put(s, item_cat.getName());
                System.out.println(s);
            }

        }
        map.put("showdiv", map1);
        return map;
    }





}
