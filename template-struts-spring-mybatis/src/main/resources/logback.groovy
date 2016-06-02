//
// Built on Sat Nov 07 13:07:02 UTC 2015 by logback-translator
// For more information on configuration files in Groovy
// please see http://logback.qos.ch/manual/groovy.html

// For assistance related to this tool or configuration files
// in general, please contact the logback user mailing list at
//    http://qos.ch/mailman/listinfo/logback-user

// For professional support please see
//   http://www.qos.ch/shop/products/professionalSupport

import ch.qos.logback.classic.PatternLayout
import ch.qos.logback.classic.db.DBAppender
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.db.DriverManagerConnectionSource
import ch.qos.logback.core.db.dialect.MySQLDialect
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy
import com.mchange.v2.c3p0.ComboPooledDataSource
import com.mysql.jdbc.Driver

import static ch.qos.logback.classic.Level.DEBUG
import static ch.qos.logback.classic.Level.INFO
import static ch.qos.logback.classic.Level.TRACE

//定义日志文件的存储地址 勿在 LogBack 的配置中使用相对路径
def USER_HOME = System.getProperty("user.home")
def LOG_HOME = "${USER_HOME}/log/logback"

//控制台输出
appender("STDOUT", ConsoleAppender) {
    encoding = "UTF-8"
    layout(PatternLayout) {
    //格式化输出：%d表示日期，%thread表示线程名，%-5level：级别从左显示5个字符宽度%msg：日志消息，%n是换行符
        pattern = "%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} - %msg%n"
    }
}

//按照每天生成日志文件
appender("FILE", RollingFileAppender) {
    encoding = "UTF-8"
    rollingPolicy(TimeBasedRollingPolicy) {
        //日志文件输出的文件名
        fileNamePattern = "${LOG_HOME}/logback.log.%d{yyyy-MM-dd}.log"
        //日志文件保留天数
        maxHistory = 30
    }
    layout(PatternLayout) {
        //格式化输出：%d表示日期，%thread表示线程名，%-5level：级别从左显示5个字符宽度%msg：日志消息，%n是换行符
        pattern = "%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} - %msg%n"
    }
    triggeringPolicy(SizeBasedTriggeringPolicy) {
        //日志文件最大的大小
        maxFileSize = "10MB"
    }
}

//show parameters for hibernate sql 专为 Hibernate 定制
//logger("org.hibernate.type.descriptor.sql.BasicBinder", TRACE)
//logger("org.hibernate.type.descriptor.sql.BasicExtractor", DEBUG)
//logger("org.hibernate.SQL", DEBUG)
//logger("org.hibernate.engine.QueryParameters", DEBUG)
//logger("org.hibernate.engine.query.HQLQueryPlan", DEBUG)

//myibatis log configure
//logger("com.apache.ibatis", TRACE)
//logger("java.sql.Connection", DEBUG)
//logger("java.sql.Statement", DEBUG)
//logger("java.sql.PreparedStatement", DEBUG)

//日志输出级别
root(INFO, ["STDOUT", "FILE","DB"])

//日志异步到数据库
appender("DB", DBAppender) {
    //日志异步到数据库
    connectionSource(DriverManagerConnectionSource) {
        //连接池
        dataSource(ComboPooledDataSource) {
            driverClass = "com.mysql.jdbc.Driver"
            url = "jdbc:mysql://127.0.0.1:3306/test"
            user = "root"
            password = "123456"
        }
    }
    sqlDialect(MySQLDialect)
}

