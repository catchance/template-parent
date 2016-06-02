import org.hello.HelloWorld

beans{
    //多种配置方式

    /*导入命名空间*/
    xmlns context: "http://www.springframework.org/schema/context"

    /*自动扫描属性*/
    context.'property-placeholder'('location':"classpath*:config.properties")

    /*自动扫描包*/
    /*use-default-filters="false"表示不要使用默认的过滤器，此处的默认过滤器，会扫描包含Service,Component,Repository,Controller注解修饰的类*/
    context.'component-scan'('base-package': "org.hello",'use-default-filters':"false"){
        'include-filter'('type':"annotation",'expression':"org.springframework.stereotype.Repository")
        'include-filter'('type':"annotation",'expression':"org.springframework.stereotype.Service")
        'exclude-filter'('type': "regex", 'expression': "org.hello.[^.]+(dao|service)")
//        'exclude-filter'('type': "aspectj", 'expression': "org.hello..*Service+")
    }

    helloWorldGroovy1(HelloWorld)

    helloWorldGroovy4 org.hello.HelloWorld

    helloWorldGroovy2(HelloWorld,"groovy config bean con")

    helloWorldGroovy3(HelloWorld){
        message='groovy config bean'
        intVal=1
        lists=['groovy1','groovy2']
        maps=['key1':'value1','key2':'value2']
    }
}