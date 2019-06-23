package cn.itcast.mapper;

import cn.itcast.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    @SelectKey(statement = "select last_insert_id()",
            resultType = Integer.class,keyProperty = "id",
            keyColumn = "id",before = false)
    List<User> queryUserAll();

    @Select("select * from user")
    @Results({
            @Result(id = true,property = "id",column ="id"),
            @Result(property = "id",column ="id",javaType = User.class,one =
            @One(select = "cn.itcast.mapper.accountMapper.queryAccountByUserId",fetchType = FetchType.LAZY)),
    })
    List<User> queryUserAlls();

}
