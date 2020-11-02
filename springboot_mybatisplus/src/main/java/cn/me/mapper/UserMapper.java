package cn.me.mapper;

import cn.me.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

//使用MybatisPlus增强接口
//继承该接口后，无需编写 mapper.xml 文件，即可获得CRUD功能
public interface UserMapper extends BaseMapper<User>
{

}
