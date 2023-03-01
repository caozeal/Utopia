package com.caozeal.leetcode._2022;

public class Reformat {

    public static void main(String[] args) {
        Reformat reformat = new Reformat();
        System.out.println(reformat.reformat("ab123c"));
    }

    public String reformat(String s) {
        int numP = 1;
        int alpP = 2;
        char[] result;
        if(s.length()%2 == 0){
            result = new char[s.length()];
        }else {
            result= new char[s.length() + 1];
        }
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) < 'a'){
                if(numP >= result.length){
                    return "";
                }
                result[numP] = s.charAt(i);
                numP += 2;
            }else{
                if(alpP == -1){
                    return "";
                }
                if(alpP >= result.length){
                    result[0] = s.charAt(i);
                    alpP = -1;
                }else {
                    result[alpP] = s.charAt(i);
                    alpP += 2;
                }
            }
        }
        if(alpP == -1){
            return String.valueOf(result, 0, s.length());
        }
        return String.valueOf(result, 1, s.length());
    }
}
