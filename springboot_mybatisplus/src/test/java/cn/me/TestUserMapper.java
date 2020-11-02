package cn.me;

import cn.me.domain.User;
import cn.me.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class TestUserMapper
{
    @Autowired
    private UserMapper userMapper;

    //查询所有
    @Test
    public void testFindAll()
    {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    //查询所有
    @Test
    public void testFindById()
    {
        System.out.println(userMapper.selectById("2"));
    }

    //条件查询
    @Test
    public void testFind()
    {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //年龄等于、小于、小于等于21的记录
//        queryWrapper.eq("age", 21);
//        queryWrapper.lt("age", 21);
//        queryWrapper.le("age", 21);

        //模糊查询，like相当于%值%，likeLeft相当于%值，即以值为结尾
//        queryWrapper.like("name", "a");
        queryWrapper.likeLeft("name", "da");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    /**
     * 测试保存
     */
    @Test
    public void testSave()
    {
        User user = new User();
        //可以链式编程，这是因为User上加了@Accessors(chain = true)，使得set方法返回了user对象
        user.setName("papa").setAge(45).setBir(new Date());
        userMapper.insert(user);
    }

    /**
     * 测试修改
     */
    @Test
    public void testUpdate()
    {
//        User user = userMapper.selectById("3");
//        user.setName("mama");
//        //基于主键id修改，传入的是个对象
//        userMapper.updateById(user);

        //批量修改
        User user = new User();
        user.setName("nana");
        QueryWrapper<User> updateWrapper = new QueryWrapper<>();
        //把所有年龄为21的名字都设为nana
        updateWrapper.eq("age", 21);
        userMapper.update(user, updateWrapper);
    }

    @Test
    public void testDelete()
    {
//        userMapper.deleteById("3");
        //条件删除
        QueryWrapper<User> deleteWrapper = new QueryWrapper<>();
        //把年龄大于23的删除
        deleteWrapper.ge("age", 23);
        userMapper.delete(deleteWrapper);
    }

    //分页查询。必须先配置分页！！！
    @Test
    public void testFindByPage()
    {
        //无条件分页，即全部分页
        //参数1：当前页默认值为1，参数2：每页显示记录数默认值为10
//        IPage<User> page = new Page<>(1, 2);
//        IPage<User> pageResult = userMapper.selectPage(page, null);
//        System.out.println("总记录数:"+pageResult.getTotal());
//        //打印分页结果
//        pageResult.getRecords().forEach(System.out::println);

        //条件分页，把年龄小于23的分页
        IPage<User> page = new Page<>(1, 2);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lt("age", 23);
        IPage<User> pageResult = userMapper.selectPage(page, queryWrapper);
        System.out.println("总记录数:" + pageResult.getTotal());
        //打印分页结果
        pageResult.getRecords().forEach(System.out::println);
    }
}
