package cn.wowspeeder.shadowsocks;

import com.alibaba.druid.pool.DruidDataSource;
import jetbrick.template.web.springmvc.JetTemplateViewResolver;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author:TongxiJi E-MAIL:694270875@qq.com
 * Function:
 * Create Date:一月09,2018
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    private static ApplicationContext context;

    public static ApplicationContext getContext() {
        return context;
    }

    public static String getEnvValue(String key) {
        return context.getEnvironment().getProperty(key);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) throws Exception {
        context = SpringApplication.run(Application.class, args);
    }


    @Bean(name = "beetlViewResolver")
    public JetTemplateViewResolver getBeetlSpringViewResolver() {
        JetTemplateViewResolver viewResolver = new JetTemplateViewResolver();
        viewResolver.setContentType("text/html;charset=UTF-8");
        viewResolver.setOrder(1);
        viewResolver.setPrefix("/templates/");
        viewResolver.setSuffix(".html");
        viewResolver.setConfigLocation("classpath:jetbrick-template.properties");
        return viewResolver;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("datasource") DataSource datasource) {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setTypeAliasesPackage("cn.wowspeeder.shadowsocks.model");

        //分页插件
//        PageHelper pageHelper = new PageHelper();
//        Properties properties = new Properties();
//        properties.setProperty("reasonable", "true");
//        properties.setProperty("supportMethodsArguments", "true");
//        properties.setProperty("returnPageInfo", "check");
//        properties.setProperty("params", "count=countSql");
//        pageHelper.setProperties(properties);

        //添加插件
//        bean.setPlugins(new Interceptor[]{(Interceptor) pageHelper});

        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager(@Qualifier("datasource") DataSource datasource) {
        return new DataSourceTransactionManager(datasource);
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("cn.wowspeeder.shadowsocks.dao");
        return mapperScannerConfigurer;
    }


    @Bean(name = "datasource")
    public DataSource druidDataSource(Environment env) {
        DruidDataSource druidDataSource = new DruidDataSource();

        druidDataSource.setDriverClassName(env.getProperty("db.driver"));
        druidDataSource.setUrl(env.getProperty("db.url"));
        druidDataSource.setUsername(env.getProperty("db.userName"));
        druidDataSource.setPassword(env.getProperty("db.passowrd"));
        druidDataSource.setValidationQuery("SELECT 1 FROM DUAL");
        druidDataSource.setInitialSize(5);
        druidDataSource.setMaxActive(10);
        druidDataSource.setMaxWait(30000);
        druidDataSource.setRemoveAbandoned(true);
        druidDataSource.setRemoveAbandonedTimeoutMillis(120000);
        return druidDataSource;
    }
}
