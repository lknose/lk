package cn.itcast.factory;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {

    public SqlSessionFactory builder() {
        //使用类加载器获取xml配置文件
        InputStream inputStream = SqlSessionFactoryBuilder.class
                .getClassLoader().getResourceAsStream("SqlMapConfig.xml");

        //创建工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactory();

        //设置inputStream
        sqlSessionFactory.setInputStream(inputStream);

        return sqlSessionFactory;
    }

    public SqlSessionFactory builder(String source) {
        //使用类加载器获取xml配置文件
        InputStream inputStream = SqlSessionFactoryBuilder.class
                .getClassLoader().getResourceAsStream(source);

        //创建工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactory();

        //设置inputStream
        sqlSessionFactory.setInputStream(inputStream);

        return sqlSessionFactory;
    }
}
