package com.caozeal.leetcode;

public class ValidateStack {

    public static void main(String[] args) {
        ValidateStack stack = new ValidateStack();
        System.out.println(stack.validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        IntegerStack stack = new IntegerStack(pushed);
        int j=0;
        for (int i : pushed) {
            stack.push(i);
            while (j<popped.length && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
        return j == popped.length;
    }

    static class IntegerStack{
        private final int[] val;

        private int size;

        public IntegerStack(int[] val){
            this.val = val;
            size = 0;
        }

        public boolean isEmpty(){
            return size == 0;
        }

        public int peek(){
            if(size == 0){
                return -1;
            }
            return val[size-1];
        }

        public int pop(){
            if(size == 0){
                return -1;
            }
            return val[--size];
        }

        public void push(int i){
            val[size++] = i;
        }
    }
}
