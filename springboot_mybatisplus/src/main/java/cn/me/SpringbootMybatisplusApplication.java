package cn.me;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.me.mapper")//这种方式更灵活，因为只要扫描一次
public class SpringbootMybatisplusApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(SpringbootMybatisplusApplication.class, args);
    }
}
