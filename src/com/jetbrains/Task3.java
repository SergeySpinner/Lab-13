package com.jetbrains;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

public class Task3 implements Runnable {
    @Override
    public void run(){
        try{
            InputStream in = new FileInputStream("F1.txt");
            ArrayList<String> array = new ArrayList<>();
            char c;
            String s = "";

            while(in.available() != 1){
                c = (char) in.read();
                s = s + c;
            }
            in.close();
            boolean key = true;
            for(String line: s.split("\\."))
            {
                if(key) {
                    array.add(line);
                    key = false;
                }
                else array.add(line.substring(1,line.length()));
            }
            Collections.sort(array);
            FileOutputStream out = new FileOutputStream("Output.txt",true);
            out.write("Task 3: ".getBytes());
            for(int i = 0; i < array.size(); i++)
                out.write((array.get(i) + "\n").getBytes());
        } catch (IOException e) { }
    }
}
