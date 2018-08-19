package com.yang.controller;

import com.yang.bean.Tb_content;
import com.yang.bean.Tb_contentExample;
import com.yang.bean.Tb_contentShow;
import com.yang.mapper.Tb_contentMapper;
import com.yang.service.ContentService;
import com.yang.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 18/8/10.
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
@RequestMapping("goto")
public class LoginController {

    @Resource
    private ContentService contentServiceImpl;

    @RequestMapping("toindex.do")
    public String toindex(Model model){

        List<Tb_contentShow> tb_contentShows = new ArrayList<>();
      List<Tb_content> contents =  contentServiceImpl.getContentList();

        for (Tb_content tb_content : contents) {
            Tb_contentShow tb_contentShow = new Tb_contentShow();
            tb_contentShow.setAlt("");
            tb_contentShow.setHeight("240");
            tb_contentShow.setWidth("550");
            tb_contentShow.setHref(tb_content.getUrl());
            tb_contentShow.setSrc(tb_content.getPic());
            tb_contentShow.setSrcB(tb_content.getPic());
            tb_contentShow.setHeightB("240");
            tb_contentShows.add(tb_contentShow);

        }
      String a =  JsonUtils.objectToJson(tb_contentShows);
        model.addAttribute("ad1", a);
        return "/jsp/index";
    }




}
