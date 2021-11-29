package com.company;

public class Calculator<T> {

    public boolean calculate(T data1, T data2, T answer){
        try{
            int value1 = Integer.parseInt(String.valueOf(data1));
            int value2 = Integer.parseInt(String.valueOf(data2));
            int ans = Integer.parseInt(String.valueOf(answer));
            return value1/value2==ans;
        }
        catch (NumberFormatException e){
            String correctAnswer = String.valueOf(data1).concat(String.valueOf(data2));
            return correctAnswer.equals(answer);
        }
    }
}
