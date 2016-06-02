
import org.springframework.jdbc.datasource.DataSourceTransactionManager


beans {

    xmlns tx: "http://www.springframework.org/schema/tx"
    xmlns aop: "http://www.springframework.org/schema/aop"

    context.'component-scan'('base-package': "org.chance.service")

    transactionManager(DataSourceTransactionManager){
        dataSource=ref("dataSource")
    }

    aop.'aspectj-autoproxy'(){}

}