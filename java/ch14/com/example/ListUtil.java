package com.example;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {
    public static List arrayToList(String[] array) {
        List list = new ArrayList();
        for (String s : array) {
            list.add(s);
        }
        return list;
    }
    
    public static void main(String[] args) {
        String[] names = {"Ariana", "April", "Sydney"};
        List list = ListUtil.arrayToList(names);
        list.add("Julie");
        for (Object name : list) {
            System.out.println(name);
        }
    }
}