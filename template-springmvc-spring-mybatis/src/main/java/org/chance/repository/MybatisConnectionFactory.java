package org.chance.repository;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * Created by wqg on 2015/12/10.
 */
public class MybatisConnectionFactory {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            String resource = "mybatis/mybatis-config.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

}
