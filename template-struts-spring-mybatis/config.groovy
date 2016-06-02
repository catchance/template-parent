environments {
    development {
        jdbc {
            url = 'jdbc:mysql://127.0.0.1:3306/chance'
            user = 'root'
            password = '123456'
            driver = 'com.mysql.jdbc.Driver'
        }
    }

    test {
        jdbc {
            url = 'jdbc:mysql://127.0.0.1:3306/chance?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull'
            user = 'root'
            password = '123456'
            driver = 'com.mysql.jdbc.Driver'
        }
    }

    production {
        jdbc {
            url = 'jdbc:mysql://127.0.0.1:3306/chance?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull'
            user = 'root'
            password = '123456'
            driver = 'com.mysql.jdbc.Driver'
        }
    }
}