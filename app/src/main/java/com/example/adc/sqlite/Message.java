package com.example.adc.sqlite;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by adc on 29-Jun-18.
 */
 public  class Message
{
    public static void message(Context context,String message)
    {
        Toast.makeText(context,message, Toast.LENGTH_SHORT).show();

    }
}
