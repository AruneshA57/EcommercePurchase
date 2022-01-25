package com.example.ecommercepurchase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Sample {
    public static void main(String[] args) {
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String date = simpleDateFormat.format(new Date());
        System.out.println(date);
    }
}
