package com.yang.service;

import com.github.pagehelper.PageHelper;
import com.yang.bean.Tb_item_cat;
import com.yang.bean.Tb_item_catExample;
import com.yang.common.pojo.EUTreeNode;
import com.yang.mapper.Tb_item_catMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 18/8/8.
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
@Service
public class Tb_item_catServiceImpl implements Tb_item_catService {

    @Resource
    private Tb_item_catMapper tb_item_catMapper;

    @Override
    public List<EUTreeNode> getItemCatList(long parentID) {
        Tb_item_catExample example = new Tb_item_catExample();
        Tb_item_catExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentID);
        List<Tb_item_cat> tb_item_cats = tb_item_catMapper.selectByExample(example);
        List<EUTreeNode> euTreeNodes = new ArrayList<>();
        for (Tb_item_cat tb_item_cat : tb_item_cats) {
            EUTreeNode euTreeNode = new EUTreeNode();
            euTreeNode.setId(tb_item_cat.getId());
            euTreeNode.setText(tb_item_cat.getName());
            euTreeNode.setState(tb_item_cat.getIsParent()?"closed":"open");
            euTreeNodes.add(euTreeNode);
        }
        return euTreeNodes;
    }

    @Override
    public List<Tb_item_cat> getItemCatHeadShow(long parentId) {
        Tb_item_catExample example = new Tb_item_catExample();
        Tb_item_catExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        PageHelper.startPage(0, 14);
        List<Tb_item_cat> item_cats= tb_item_catMapper.selectByExample(example);
        return item_cats;
    }
}
