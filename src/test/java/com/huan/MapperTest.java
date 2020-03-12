package com.huan;


import com.alibaba.fastjson.JSONObject;
import com.huan.dao.ItemMappper;
import com.huan.domain.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringbootdemoApplication.class)
public class MapperTest {
    @Autowired
    private ItemMappper mappper;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void testQuery() {
        List<Item> items = mappper.queryItemList();
        System.out.println(items);

    }
    @Test
    public void redisTest(){
        List<Item> items=new ArrayList<Item>();
        String itemsJson=redisTemplate.boundValueOps("item.findAll").get();
        if(itemsJson==null){
            items = mappper.queryItemList();
            System.out.println("从db获取数据"+items);
            redisTemplate.boundValueOps("item.findAll").set(JSONObject.toJSONString(items));
        }else{
            items=JSONObject.parseArray(itemsJson,Item.class);
            System.out.println("从reids获取数据"+items);
        }
    }
}
