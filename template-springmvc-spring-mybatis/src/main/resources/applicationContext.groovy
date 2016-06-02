
beans{

    /*导入命名空间*/
    xmlns context: "http://www.springframework.org/schema/context"

    /*自动扫描属性*/
    context.'property-placeholder'('location':"classpath*:config.properties,classpath*:mysql.properties")
//  context.'property-placeholder'('location':"classpath*:mysql.properties")

    importBeans "classpath:spring/spring-mvc.groovy"
    importBeans "classpath:spring/spring-service.groovy"
    importBeans "classpath:spring/spring-mybatis.groovy"
}
