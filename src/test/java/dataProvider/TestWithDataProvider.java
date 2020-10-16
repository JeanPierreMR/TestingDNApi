package dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestWithDataProvider {
    @DataProvider
    public Object[][] studentsDP(){
        return new Object[][]{
                {1, "Jake"},
                {2, "Sakura"},
                {3, "Juan"}
        };
    }



    @Test(dataProvider = "studentsDP", groups = {"dataProvider"})
    public void testWithDP(int id, String name){
        System.out.println("ID: "+ id);
        System.out.println("Student: "+ name);
    }
}
