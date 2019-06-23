import cn.itcast.core.SqlSession;
import cn.itcast.factory.SqlSessionFactory;
import cn.itcast.factory.SqlSessionFactoryBuilder;
import cn.itcast.mapper.RoleMapper;
import cn.itcast.mapper.UserMapper;
import cn.itcast.model.Role;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory builder = sqlSessionFactoryBuilder.builder();
        SqlSession sqlSession = builder.openSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        List<Role> roleAll = mapper.getRoleAll();
        for (Role role : roleAll) {
            System.out.println(role);
        }
    }
}
