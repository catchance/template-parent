beans{
    //多种配置方式

    /*导入命名空间*/
    xmlns context: "http://www.springframework.org/schema/context"

    /*自动扫描属性*/
    context.'property-placeholder'('location':"classpath*:config.properties")

    /*自动扫描包*/
    /*use-default-filters="false"表示不要使用默认的过滤器，此处的默认过滤器，会扫描包含Service,Component,Repository,Controller注解修饰的类*/
    context.'component-scan'('base-package': "org.chance.action.*"){
    }

}