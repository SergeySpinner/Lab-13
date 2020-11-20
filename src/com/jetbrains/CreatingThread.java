package com.jetbrains;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class CreatingThread extends Thread{
    @Override
    public void run(){
        try{FileOutputStream out = new FileOutputStream(new File("Output.txt")); }
        catch (FileNotFoundException e) { }
    }
}
