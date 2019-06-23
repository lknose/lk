package cn.itcast.mapper;

import cn.itcast.ann.Select;
import cn.itcast.model.Role;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    @Select("select * from um_role")
    public List<Role> getRoleAll(){
        return new ArrayList<>();
    };
}
