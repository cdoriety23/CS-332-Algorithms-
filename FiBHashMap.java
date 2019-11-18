package com.company;

import java.util.HashMap;

//fibanocci using dynamic programming
public class Main {

    public static void main(String[] args) {
	 System.out.println(fib(5));// should return 5
        System.out.println(fib(6)); //should return 8
        System.out.println(fib(10));// should return 55
    }

    public static HashMap<Integer, Integer> num = new HashMap<Integer, Integer>();
    public static int fib(int n) {
        if(num.containsKey(n)) 
	{
		return num.get(n);
	}
        if(n == 0) 
	{
		return 0;
	}
        if(n == 1) 
	{
		return 1;
	}
        
	    	int Value = fib(n - 1) + fib(n - 2);
        	num.put(n, Value);
        return Value;
    }
    {

    }



}
