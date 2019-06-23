package cn.itcast.mapper;

import cn.itcast.ann.Select;
import cn.itcast.model.Role;

import java.util.List;

public interface RoleMapper {

    @Select("select * from um_role")
    public List<Role> getRoleAll();
}
