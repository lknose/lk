package cn.itcast.core;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class JdbcConfig {

    @Value("${url}")
    private String url;
    @Value("${driver}")
    private String driver;

    @Bean("dataSource")
    @Scope((ConfigurableBeanFactory.SCOPE_SINGLETON) )
    public DataSource createDataSource() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean
    public QueryRunner createQueryRunner(@Qualifier("dataSource") DataSource dataSource) {
        QueryRunner queryRunner = new QueryRunner(dataSource);
        return queryRunner;
    }
}
