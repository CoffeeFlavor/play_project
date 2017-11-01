import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: jennie
 * Date: 2017/8/11
 * Time: 14:06
 */

public class LambdaTest {

    @Test
    public void test(){

        List<String> strings=new ArrayList<String>();
        strings.add("1");
        strings.add("3");
        strings.add("2");
        strings.add("5");
        strings.add("6");
        Arrays.sort(strings,String::compareToIgnoreCase);
    }

    public static void main(String[] args) {

        List<String> strings=new ArrayList<String>();
        strings.add("1");
        strings.add("3");
        strings.add("2");
        strings.add("5");
        strings.add("6");
        Arrays.sort(strings,String::compareToIgnoreCase);
    }
}
