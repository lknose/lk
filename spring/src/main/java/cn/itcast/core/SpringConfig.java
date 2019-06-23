package cn.itcast.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("cn.itcast")
@EnableAspectJAutoProxy
@EnableTransactionManagement
@Import(SpringConfig.class)
public class SpringConfig {
}
