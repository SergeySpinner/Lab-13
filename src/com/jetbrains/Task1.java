package com.jetbrains;

import java.io.*;
import java.util.TreeSet;

public class Task1 implements Runnable {
    @Override
    public void run() {
        try {
            InputStream in = new FileInputStream("F1.txt");
            TreeSet<String> tempTreeSet = new TreeSet<String>();
            char c;
            String s = "";
            while (in.available() != 1) {
                c = (char) in.read();
                if (c != ' ' && c != '.' && (int) c != 10) s = s + c;
                else {
                    tempTreeSet.add(s.toLowerCase());
                    s = "";
                }
            }
            in.close();
            FileOutputStream out = new FileOutputStream("Output.txt");

            out.write("Task 1:".getBytes());

            for (var temp : tempTreeSet)
                out.write((temp + " ").getBytes());
            out.write("\n".getBytes());

        } catch (IOException e) { }
    }
}
