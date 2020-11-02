package cn.me;

import cn.me.domain.User;
import cn.me.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class TestUserService
{
    @Autowired
    private UserService userService;

    @Test
    public void testFindAll()
    {
        //默认走主库
        userService.findAll().forEach(System.out::println);
    }

    @Test
    public void testSaveUser()
    {
        User user = new User();
        user.setName("kaka").setBir(new Date()).setAge(99);
        userService.saveUser(user);
    }
}
