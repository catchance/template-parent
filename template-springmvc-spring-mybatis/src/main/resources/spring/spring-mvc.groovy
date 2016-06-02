import org.springframework.context.support.ReloadableResourceBundleMessageSource
//import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean
import org.springframework.web.servlet.i18n.CookieLocaleResolver
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor
import org.springframework.web.servlet.view.InternalResourceViewResolver

beans{
    //多种配置方式

    /*导入命名空间*/
    xmlns context: "http://www.springframework.org/schema/context"
    xmlns mvc: "http://www.springframework.org/schema/mvc"


    /*自动扫描属性*/
    context.'property-placeholder'('location':"classpath*:config.properties")

    /*自动扫描包*/
    /*use-default-filters="false"表示不要使用默认的过滤器，此处的默认过滤器，会扫描包含Service,Component,Repository,Controller注解修饰的类*/
    context.'component-scan'('base-package': "org.chance.controller"){
    }

//    validator(LocalValidatorFactoryBean) {
//        providerClass = HibernateValidator.class
//
//        //如果不加默认到 使用classpath下的 ValidationMessages.properties
//        validationMessageSource = ref("messageSource")
//    }

    //国际化的消息资源文件
    messageSource(ReloadableResourceBundleMessageSource) {
        basenames = ["classpath:messages", "classpath:org/hibernate/validator/ValidationMessages"]
        defaultEncoding = "UTF-8"
        cacheSeconds = 60
    }

    // 对静态资源文件的访问 方案二 （二选一）
    mvc.'resources'('mapping':'/images/**','location':'/images/','cache-period':'31556926'){
    }
    mvc.'resources'('mapping':'/js/**','location':'/js/','cache-period':'31556926'){
    }
    mvc.'resources'('mapping':'/css/**','location':'/css/','cache-period':'31556926'){
    }

    //对静态资源文件的访问 方案一
//    mvc.'default-servlet-handler'(){}

//    requestMappingHandlerAdapter(org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter)
//    requestMappingHandlerMapping(org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping)
//   adapter和mapping可以使用annotation-driven代替简写
    mvc.'annotation-driven'()


//定义跳转文件的前后缀，试图模式配置
    viewResolver(InternalResourceViewResolver) {
        prefix = "/WEB-INF/content/"
        suffix = ".jsp"
    }

    mvc.interceptors() {
        localeChangeInterceptor(LocaleChangeInterceptor) {
            paramName = "language"
        }
    }

    /*当路径为/的时候直接跳转到/index.jsp的页面去*/
    mvc.'view-controller'('path':'/','view-name':"index"){

    }

//    defaultViewResolver(org.springframework.web.servlet.view.InternalResourceViewResolver){
//
//    }
    //上传文件设置
//    multipartResolver(org.springframework.web.multipart.commons.CommonsMultipartResolver){
//        maxUploadSize=5000000
//    }

    cookieLocaleResolver(CookieLocaleResolver) {
        cookieName = "language"
        cookieMaxAge = "3600"
        defaultLocale = "zh_CN"
    }

    instantiationTracingBeanPostProcessor(org.chance.listener.InstantiationTracingBeanPostProcessor)

    importBeans "classpath:spring/spring-import.groovy"
}