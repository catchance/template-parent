package spring

import org.hello.HelloWorld
import org.hello.aop.MyAspect
import org.hello.xml.MessagePrinter
import org.hello.xml.MessageServiceImpl

beans{
    //多种配置方式

    /*导入命名空间*/
    xmlns context: "http://www.springframework.org/schema/context"
    xmlns aop: "http://www.springframework.org/schema/aop"
    xmlns util: "http://www.springframework.org/schema/util"

    /*自动扫描属性*/
    context.'property-placeholder'('location':"classpath*:config.properties")

    /*自动扫描包*/
    /*use-default-filters="false"表示不要使用默认的过滤器，此处的默认过滤器，会扫描包含Service,Component,Repository,Controller注解修饰的类*/
    context.'component-scan'('base-package': "org.hello.annotation.*"/*,'use-default-filters':"false"*/){
//        'include-filter'('type':"annotation",'expression':"org.springframework.stereotype.Repository")
//        'include-filter'('type':"annotation",'expression':"org.springframework.stereotype.Service")
//        'include-filter'('type':"annotation",'expression':"org.springframework.stereotype.Component")
//        'exclude-filter'('type': "regex", 'expression': "org.hello.[^.]+(dao|service)")
//        'include-filter'('type':"aspectj",'expression':"org.hello.*")
//        'include-filter'('type':"aspectj",'expression':"org.hello.annotation.*")
//        'exclude-filter'('type': "aspectj", 'expression': "org.hello.xml.*")
    }

    message(String,"hello"){}

    messageService(MessageServiceImpl){
        message="hello"
    }

    messagePrinter(MessagePrinter,messageService)

    myAspect(MyAspect)

    aop{
        config("proxy-target-class":true){
            aspect(id:"test",ref:"myAspect"){
                before method: "before", pointcut: "execution(void org.hello..*.*(..))"
            }
        }
    }

    util.map(id:'map'){
        entry(key:1,value:1)
        entry('key-ref':"messageService",'value-ref':"messageService")
    }

    helloWorldGroovy1(HelloWorld)

    helloWorldGroovy4 org.hello.HelloWorld

    helloWorldGroovy2(HelloWorld,"groovy config bean one!")

    helloWorldGroovy3(HelloWorld){
        message='groovy config bean'
        intVal=1
        lists=['groovy1','groovy2']
        maps=['key1':'value1','key2':'value2']
    }
}