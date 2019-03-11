package com.caozeal.practice.algorithm.calculator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * <p>创建时间：2019/2/12 18:20
 * <p>com.caozeal.practice.algorithm.calculator
 * @author caozhiyong
 * @version 1.0
 */
public class First {

    public static void main(String[] args) {
        String[] operate = {"*", ""};
        long begin = System.currentTimeMillis();
        for (int i=1000; i<10000; i++){
            if(i%10 == 0) continue;
            String num = String.valueOf(i);
            for(int j=0; j<2; j++){
                for(int k=0; k<2; k++){
                    for(int l=0; l<2; l++){
                        StringBuilder formula = new StringBuilder().append(num.charAt(3)).append(operate[j]).append(num.charAt(2))
                                .append(operate[k]).append(num.charAt(1)).append(operate[l]).append(num.charAt(0));
                        if(formula.length()>4){
                            try {
                                String result = eval(formula.toString());
                                if(num.equals(result)){
                                    System.out.println(num + " = " + formula);
                                }
                            } catch (ScriptException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        System.out.println(System.currentTimeMillis() - begin);
    }

    private static String eval(String formula) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine jsEngine = manager.getEngineByName("js");
        Object result = jsEngine.eval(formula);
        return String.valueOf(result);
    }
}
