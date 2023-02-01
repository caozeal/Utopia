package com.caozeal.leetcode;

public class Interpret {

    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<command.length(); i++){
            if(command.charAt(i) == 'G'){
                sb.append("G");
                continue;
            }
            if(command.charAt(++i) == ')'){
                sb.append("o");
                continue;
            }
            i = i+2;
            sb.append("al");
        }
        return sb.toString();
    }
}
