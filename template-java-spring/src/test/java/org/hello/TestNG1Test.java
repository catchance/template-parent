package org.hello;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by chance on 2015/11/8.
 */
public class TestNG1Test {
    @BeforeClass
    public void setUp() {
        System.out.println("setUp");
    }

    @Test(groups = { "slow" })
    public void aSlowTest1() {
        System.out.println("slow test1");
    }

    @Test(groups = { "fast" })
    public void aFastTest1() {
        System.out.println("fast test1");
    }

}
