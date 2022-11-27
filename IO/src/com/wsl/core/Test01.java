package com.wsl.core;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

/**
 * @author 2che
 */
public class Test01 {

    public static void main(String[] args) throws FileNotFoundException {
        testPrintWriter();
    }

    /**
     * 打印流测试
     */
    public static void testPrintWriter() throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream("E:\\source\\Code\\CoreJava\\IO\\src\\data.txt")));
        out.print("图奇");
        out.print("25 years old.");
        out.print("Salary is ￥14000.");
        out.flush();
        out.close();
    }


    /**
     *
     */
    public static void testReadText(){
    }
}
