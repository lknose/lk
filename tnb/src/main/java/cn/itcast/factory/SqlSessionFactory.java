package cn.itcast.factory;

import cn.itcast.core.SqlSession;
import cn.itcast.core.impl.SqlSessionImpl;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

public class SqlSessionFactory {

    private InputStream inputStream;

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public SqlSession openSession() {
        SqlSessionImpl sqlSession = new SqlSessionImpl();

        readXml(sqlSession);

        return sqlSession;
    }

    private void readXml(SqlSessionImpl sqlSession) {
        try {
            //读取xml获取Document对象
            Document document = new SAXReader().read(inputStream);
            //获取root根
            Element root = document.getRootElement();
            //获取property标签,在跟节点下获取所有的property元素
            List<Element> list = root.selectNodes("//property");
            //创建数据源
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            //遍历元素,设置数据源的信息
            for (Element element : list) {
                String name = element.attributeValue("name");
                String value = element.attributeValue("value");
                switch (name) {
                    case "driver":
                        dataSource.setDriverClass(value);
                        break;
                    case "url":
                        dataSource.setJdbcUrl(value);
                        break;
                    case "username":
                        dataSource.setUser(value);
                        break;
                    case "password":
                        dataSource.setPassword(value);
                        break;
                }
            }
            //创建QueryRunner
            QueryRunner queryRunner = new QueryRunner(dataSource);
            //设置到SqlSession
            sqlSession.setQueryRunner(queryRunner);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
