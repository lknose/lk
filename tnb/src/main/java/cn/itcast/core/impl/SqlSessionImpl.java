package cn.itcast.core.impl;

import cn.itcast.ann.Select;
import cn.itcast.core.SqlSession;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class SqlSessionImpl implements SqlSession {
    private QueryRunner queryRunner;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    public <T> T getMapper(Class<T> clazz) {
        //使用Proxy创建代理对象,第一个参数是类加载器,第二个参数是需要创建实例的接口的Class类型
        Class<?>[] interfaces = clazz.getInterfaces();
        return (T) Proxy.newProxyInstance
                (clazz.getClassLoader(), new Class[]{clazz}, new MapperInvocationHandler());
    }

    class MapperInvocationHandler implements InvocationHandler {
        //处理接口方法的具体逻辑
        //返回值Object就是方法执行后的返回值
        //参数proxy:就是代理对象
        //参数:method:就是需要执行的方法,其实就是需要实现的接口方法.
        //参数args:需要实现的方法的参数
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //获取sql语句,获取注解Select,获取注解的value
            //参数就是需要获取的注解的class类型,通过value方法获取到sql语句
            String sql = method.getAnnotation(Select.class).value();
            //获取方法的返回值java.util.List<com.itheima.pojo.User>
            String type = method.getGenericReturnType().toString();
            //<com.itheima.pojo.User>
            type = type.replace(List.class.getName(), "");
            type = type.replace("<", "");
            type = type.replace(">", "");//最终得到com.itheima.pojo.User
            Class clazz = Class.forName(type);
            //使用DButils的QueryRunner查询
            Object list = queryRunner.query(sql, new BeanListHandler(clazz));
            return list;
        }
    }
}
