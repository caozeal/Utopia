package com.caozeal.practice.algorithm.calculator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * <p>创建时间：2019/2/12 18:20
 * <p>com.caozeal.practice.algorithm.calculator
 * @author caozhiyong
 * @version 1.0
 */
public class Second {

    private static ScriptEngine jsEngine;

    public static void main(String[] args) throws InterruptedException {
        long begin = System.currentTimeMillis();
        ScriptEngineManager manager = new ScriptEngineManager();
        jsEngine = manager.getEngineByName("js");
        ExecutorService executorService = Executors.newFixedThreadPool(9);
        for(int i=1; i<10; i++){
            final int temp = i;
            executorService.execute(()->{
                for(int j=1000*temp; j<1000*(temp+1); j++){
                    if(j%10 == 0) continue;
                    String num = String.valueOf(j);
                    exec(num);
                }
                System.out.println(System.currentTimeMillis() - begin);
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(100L, TimeUnit.SECONDS);
    }

    private static void exec(String num) {
        String[] operate = {"*", ""};
        for(int j=0; j<2; j++){
            for(int k=0; k<2; k++){
                for(int l=0; l<2; l++){
                    if(j==1 && k==1 && l==1) continue;
                    StringBuilder formula = new StringBuilder().append(num.charAt(3)).append(operate[j]).append(num.charAt(2))
                                                               .append(operate[k]).append(num.charAt(1)).append(operate[l]).append(num.charAt(0));
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

    private static String eval(String formula) throws ScriptException {
        Object result = jsEngine.eval(formula);
        return String.valueOf(result);
    }
}
