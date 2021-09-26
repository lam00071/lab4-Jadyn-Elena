package com.company;

// Created by Jadyn and Elena

import java.util.*;

public class BinPacking{
    public static final Scanner scanner = new Scanner(System.in);
    private static int capacity = 0;
    private static int amount = 0; //total amount of numbers users want to use


    public static void main(String[] args) {
        String[] list = askUser();

        //To check if users give the right amount of numbers required.
        if (amount != list.length) {
            System.out.println("You did not enter the right amount of inputs.");
            askUser();
        }

        binPacking(amount,capacity,list);
    }

    // This method will ask users to enter the inputs
    // in order: capacity, total amount of numbers, the set of numbers.
    private static String[] askUser() {
        System.out.println("Please enter your inputs in order: capacity, total amount of numbers, " +
                "your set of numbers.");

        String[] inputs = scanner.nextLine().split(" ");

        List<String> list = Arrays.asList(inputs);
        int c = Integer.parseInt(list.get(0));
        int n = Integer.parseInt(list.get(1));

        capacity = c;
        amount = n;

        List<String> list2 = list.subList(2,list.size());
        String[] finalList = list2.toArray(new String[0]);

        return finalList;
    }

    private static void  binPacking(int amount, int capacity, String[] list) {
        int bin1size= capacity;
        int bin2size= capacity;
        int bin3size= capacity;

        Queue<Integer> bin1 = new LinkedList();
        Queue<Integer> bin2 = new LinkedList();
        Queue<Integer> bin3 = new LinkedList();
        Queue<Integer> noBin = new LinkedList();

        Arrays.sort(list);
        for(int i= amount -1; i>= 0; i--){
            if(Integer.parseInt(list[i])<= bin1size){
                // add to bin 1 and start loop again
                bin1.add(Integer.parseInt(list[i]));
                bin1size = bin1size - Integer.parseInt(list[i]);
            }
            else if(Integer.parseInt(list[i])<= bin2size){
                // add to bin 2 and start loop again
                bin2.add(Integer.parseInt(list[i]));
                bin2size = bin2size - Integer.parseInt(list[i]);
            }
            else if(Integer.parseInt(list[i])<= bin3size){
                // add to bin 3 and start loop again
                bin3.add(Integer.parseInt(list[i]));
                bin3size = bin3size - Integer.parseInt(list[i]);
            }
            else noBin.add(Integer.parseInt(list[i]));
        }
        System.out.println("This is the contents of bin 1: " + bin1);
        System.out.println("This is the contents of bin 2: " + bin2);
        System.out.println("This is the contents of bin 3: " + bin3);
        System.out.println("These are the leftover numbers: " + noBin);
    }
}