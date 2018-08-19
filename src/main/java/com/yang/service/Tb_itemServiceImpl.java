package com.yang.service;

import com.yang.bean.*;
import com.yang.common.pojo.TaotaoResult;
import com.yang.mapper.Tb_itemMapper;
import com.yang.mapper.Tb_item_catMapper;
import com.yang.mapper.Tb_item_descMapper;
import com.yang.utils.IDUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by dllo on 18/8/7.
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
public class Tb_itemServiceImpl implements Tb_itemService {

    @Resource
    private Tb_itemMapper tb_itemMapper;
    @Resource
    private Tb_item_descMapper tb_item_descMapper;
    @Resource
    private Tb_item_catMapper tb_item_catMapper;
    @Override
    public List<Tb_item> select_Tb_itemAll() {
        return null;
    }

    @Override
    public TaotaoResult createItem(Tb_item tb_item, String desc) throws Exception {
        long itemId = IDUtils.genItemId();
        tb_item.setId(itemId);
        tb_item.setStatus((byte) 1);
        tb_item.setCreated(new Date());
        tb_item.setUpdated(new Date());
        tb_itemMapper.insert(tb_item);
        insertItemDesc(itemId,desc);
        return TaotaoResult.ok();
    }

    @Override
    public Map<String, Map<String, Map<String, Object>>> select_Tb_item_catShow() {

        //map1
        Map<String, Map<String, Map<String, Object>>> map1 = new HashMap<>();


        Tb_item_catExample example = new Tb_item_catExample();
        Tb_item_catExample.Criteria criteria =example.createCriteria();
        criteria.andIsParentEqualTo(false);
        //查出所有是Parent的item_cats
        List<Tb_item_cat> item_cats = tb_item_catMapper.selectByExample(example);
        //随机出五个
        List<Tb_item_cat> temp = new ArrayList<>();
        Iterator<Tb_item_cat> item_catIterator = item_cats.iterator();
        while (item_catIterator.hasNext()) {
            Tb_item_cat item_cat = item_catIterator.next();
            Tb_itemExample example1 = new Tb_itemExample();
           Tb_itemExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andCidEqualTo(item_cat.getId());
            List<Tb_item> tb_items = tb_itemMapper.selectByExample(example1);
            if (tb_items.size()==0){
                item_catIterator.remove();
            }else {
                temp.add(item_cat);
            }

        }
        List<Tb_item_cat> item_catsnew = Tb_itemServiceImpl.createRandomList(temp, 5);


        int c = 1;
        for (Tb_item_cat tb_item_cat : item_catsnew) {
            Map<String, Map<String, Object>> map2 = new HashMap<>();

            Tb_itemExample itemExample= new Tb_itemExample();
            Tb_itemExample.Criteria itemcriteria= itemExample.createCriteria();
            itemcriteria.andCidEqualTo(tb_item_cat.getId());
            List<Tb_item> items = tb_itemMapper.selectByExample(itemExample);

            List<Tb_item> itemsnew = Tb_itemServiceImpl.createRandomList(items, 10);
            for (Tb_item tb_item : itemsnew) {
                if (c>=11){
                    c = 1;
                }
                Map<String, Object> map3 = new HashMap<>();
                map3.put("d",tb_item.getImage());
                map3.put("e","0");
                map3.put("c",tb_item.getPrice().toString());
                map3.put("a",tb_item.getId().toString());
                map3.put("b",tb_item.getSellPoint());
                map3.put("f",1);
                map2.put(String.valueOf(c), map3);
                c++;
            }
            map1.put(String.valueOf(tb_item_cat.getId()), map2);

        }

        return map1;

    }


    private void insertItemDesc(long itemId,String desc){
        //创建一个商品描述表对应的pojo
        Tb_item_desc itemDesc = new Tb_item_desc();
        //补全pojo的属性
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(new Date());
        itemDesc.setUpdated(new Date());
        //向商品描述表插入数据
        tb_item_descMapper.insert(itemDesc);

    }




    private static List createRandomList (List list ,int n ){

        Map map = new HashMap();
        List listNew = new ArrayList<>();
        if (list.size()<=n){
            return list;
        }else {
            while (map.size()<n){
                int random = (int) (Math.random() * list.size());

                if (!map.containsKey(random)) {
                    map.put(random, "");
                    listNew.add(list.get(random));
                }
            }

            return listNew;
        }
    }

}
