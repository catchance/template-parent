package org.hello;

import org.testng.annotations.*;

/**
 * Created by chance on 2015/11/7.
 */
public class TestNGTest {

    @BeforeClass
    public void beforeTest() {
        System.out.println("before");
    }

    @Test(groups = { "slow" })
    public void aSlowTest() {
        System.out.println("slow test");
    }

    @Test(groups = { "fast" })
    public void aFastTest() {
//        assert 1==2;
        System.out.println("fast test");
    }

    @Parameters("test1")
    @Test
    public void testParaTest(String test1){
//        assert "test1".equals(test1);
        System.out.println("This is " + test1);
    }

    //异常测试
    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp="NullPoint")
    public void testException(){
        throw new IllegalArgumentException("NullPoint");
    }

    @DataProvider(name="user")
    public Object[][] Users(){
        return new Object[][]{
                {"root","passowrd"},
                {"cnblogs.com", "tankxiao"},
                {"tank","xiao"}
        };
    }

    @Test(dataProvider="user")
    public void verifyUser(String userName, String password){
        System.out.println("Username: "+ userName + " Password: "+ password);
    }

    //TestNG忽略测试
    @Test(enabled = false)
    public void testIgnore(){
        System.out.println("This test case will ignore");
    }

    //依赖测试
    @Test
    public void setupEnv(){
        System.out.println("this is setup Env");
    }

    @Test(dependsOnMethods = {"setupEnv"})
    public void testMessage(){
        System.out.println("this is test message");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("this is after class");
    }

}
