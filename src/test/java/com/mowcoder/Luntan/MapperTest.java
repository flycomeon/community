package com.mowcoder.Luntan;

import com.mowcoder.Luntan.dao.DiscussPostMapper;
import com.mowcoder.Luntan.dao.UserMapper;
import com.mowcoder.Luntan.entity.DiscussPost;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = App.class)
public class MapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void test(){
       List<DiscussPost> list=discussPostMapper.selectDisscusPosts(0,0,10);
        for(DiscussPost disscusPost:list)
            System.out.println(disscusPost);
        int rows=discussPostMapper.selectDisscusPostRows(149);
        System.out.println(rows);

    }

}
