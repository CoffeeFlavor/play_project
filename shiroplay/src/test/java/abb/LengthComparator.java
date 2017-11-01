package abb;

import java.util.Comparator;

/**
 * User: jennie
 * Date: 2017/8/14
 * Time: 10:30
 */
public class LengthComparator implements Comparator<String> {


    public int compare(String o1, String o2) {
        return Integer.compare(o1.length(),o2.length());
    }
}
