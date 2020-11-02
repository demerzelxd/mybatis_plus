package cn.me.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
//指定数据库中对应的表名，什么都不写则默认寻找类名对应的表名
@TableName("t_user")
public class User
{
    //IdType指定主键生成类型，这里默认自增
    @TableId(value = "id", type = IdType.AUTO)
    private String id;
    //映射表中的username列
//    @TableField("username")
    private String name;
    private Integer age;
    private Date bir;

    //此实体类与表中无关的属性
    //可以设定该属性exist=false，这样就不会映射过来了
    @TableField(exist = false)
    private String aaa;
}
