package algo.strings;

import java.util.Arrays;

public class StringManipulation {

    private StringManipulation(){}

    static String sortString(String s){
        char[] strArr=s.toCharArray();
        Arrays.sort(strArr);//nlogn where n is length of string
        return Arrays.toString(strArr);
    }

    static String reverseString(String s){
        return new StringBuilder(s).reverse().toString();
    }
}
