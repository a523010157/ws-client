package com.xubo;

import java.util.Random;

/**
 * Created with IDEA
 *
 * @description: 随机字符串生成器
 * @author: xubo
 * @create: 2018-10-08 16:56
 */
public class RandomStringUtil {

    public static String getRandomString(int length){
        String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0; i<length; ++i){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

}
