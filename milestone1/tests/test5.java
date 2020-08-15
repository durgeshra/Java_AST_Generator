package com.journaldev.files;

import java.io.File;

public class FileSeparator {

    public static void main(String[] args) {
        System.out.println("File.separator = "+File.separator);
        System.out.println("File.separatorChar = "+File.separatorChar);
        System.out.println("File.pathSeparator = "+File.pathSeparator);
        System.out.println("File.pathSeparatorChar = "+File.pathSeparatorChar);


File fileUnsafe = new File("tmp/abc.txt");


File fileSafe = new File("tmp"+File.separator+"abc.txt");
    }

}




















