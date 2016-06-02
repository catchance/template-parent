import com.mchange.v2.c3p0.ComboPooledDataSource
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.mapper.MapperScannerConfigurer
import org.springframework.core.io.ClassPathResource

def properties = new Properties()
properties.load(new ClassPathResource('mysql.properties').inputStream)

beans {
    dataSource(ComboPooledDataSource){
        user=properties.mybatisUser
        password=properties.mybatisPassword
        driverClass=properties.mybatisDriver
        jdbcUrl=properties.mybatisUrl
    }

    sqlSessionFactory(SqlSessionFactoryBean){
        dataSource=ref(dataSource)
        configLocation='classpath:mybatis-config.xml'
        mapperLocations='classpath:org/chance/**/mapper/*.xml'
    }

    mapperScannerConfigurer(MapperScannerConfigurer){
        basePackage='org.chance.mapper'
        sqlSessionFactoryBeanName='sqlSessionFactory'
    }



}