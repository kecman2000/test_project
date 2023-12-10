package tests;

import helpers.BaseHelper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ProteiniSearchTest.class,
        ProteiniSiOrderingTest.class,
        ProteiniSiLoginTest.class
})

public class TestRunner extends BaseHelper {
    @BeforeClass
    public static void testInit() {
        driver.manage().window().maximize();
    }


    @AfterClass
    public static void testTearDown() {
        driver.close();
        driver.quit();
    }
}