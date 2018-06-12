package com.forezp.servicefeign;

import java.util.Random;

/**
 * @author : jennie
 * @date: 2018/4/18
 * @Time: 14:23
 */
public class HelloWorld {

    public static void main(String ... args) {
        System.out.println(randomString(-229985452)+' '+randomString(-147909649));
    }

    public static String randomString(int seed) {
        Random rand = new Random(seed);
        StringBuilder sb = new StringBuilder();
        while(true) {
            int n = rand.nextInt(27);
            if (n == 0) break;
            sb.append((char) ('`' + n));
        }
        return sb.toString();
    }
//
//    作者：David
//    链接：https://www.zhihu.com/question/37760140/answer/86901890
//    来源：知乎
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
