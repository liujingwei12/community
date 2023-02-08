package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussMapper discussMapper;
    @Test
    public void testSelectById(){
        User user = userMapper.selectById(101);
        System.out.println(user);
        User user2 = userMapper.selectByName("liubei");
        System.out.println(user2);
        User user3 = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user3);
    }
    @Test
    public void insertUser(){
        User new_user=new User();
        new_user.setUsername("ljw");
        new_user.setEmail("123456@qq.com");
        new_user.setPassword("123456");
        new_user.setSalt("abc");
        new_user.setCreateTime(new Date());
        new_user.setHeaderUrl("http://www.nowcoder.com/101.png");
        int i = userMapper.insertUser(new_user);
        System.out.println(i);
    }
    @Test
    public void testUpdate(){
        userMapper.updateStatus(150,1);
        userMapper.updateHeader(150,"http://localhost:8080/102.png");
        userMapper.updatePassword(150,"ljw092412");
    }
    @Test
    public void testDiscuss(){
        List<DiscussPost> discussPosts = discussMapper.selectDiscussPosts(0,1,5);
        discussPosts.stream().forEach(System.out::println);
        System.out.println();
        List<DiscussPost> discussPosts1 = discussMapper.selectDiscussPosts(149,1,5);
        System.out.println(discussPosts1);
        System.out.println();
        int allRows = discussMapper.selectDiscussPostRows(0);
        System.out.println("总共： "+allRows);
        int i = discussMapper.selectDiscussPostRows(149);
        System.out.println("id=3: "+i);


    }
}
