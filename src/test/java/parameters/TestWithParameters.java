package parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

public class TestWithParameters {
    @Test
    @Parameters({"FirstParameter", "SecondParameter"})
    public void test_case_with_parameters(String param1, String param2){
        System.out.println(param1 + " " + param2);
    }

}
