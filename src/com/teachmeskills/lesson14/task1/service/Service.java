package com.teachmeskills.lesson14.task1.service;

import com.teachmeskills.lesson14.task1.constant.Сonstant;

import java.io.*;

public class Service {
    public static void service() {
        File dir = new File(Сonstant.PATH);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(dir));
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
        }
        String line = null;
        while (true) {
            try {
                if (!((line = br.readLine()) != null)) break;
            } catch (IOException e) {
                System.out.println("The file is unreadable");
                FileWriter writer = null;
                try {
                    writer = new FileWriter(Сonstant.ERROR_LOG, true);
                } catch (IOException ex) {
                    System.out.println("Write error");
                }
                try {
                    writer.write("The file is unreadable" + "\n");
                } catch (IOException ex) {
                    System.out.println("Write error");
                }
            }
            if (line.matches(Сonstant.DOC_NUM)) {
                try (FileWriter writer = new FileWriter(Сonstant.DOC, true)) {
                    writer.write("Valid document number: " + line + "\n");
                } catch (IOException e) {
                    System.out.println("Write error");
                    FileWriter writer = null;
                    try {
                        writer = new FileWriter(Сonstant.ERROR_LOG, true);
                    } catch (IOException ex) {
                        System.out.println("Write error");
                    }
                    try {
                        writer.write("Write error" + "\n");
                    } catch (IOException ex) {
                        System.out.println("Write logs error");
                    }
                }
            }
            if (line.matches(Сonstant.CONTRACT)) {
                try (FileWriter writer1 = new FileWriter(Сonstant.CON, true)) {
                    writer1.write("Valid contract number: " + line + "\n");
                } catch (IOException e) {
                    System.out.println("Write error");
                    FileWriter writer = null;
                    try {
                        writer = new FileWriter(Сonstant.ERROR_LOG, true);
                    } catch (IOException ex) {
                        System.out.println("Write error");
                    }
                    try {
                        writer.write("Write error" + "\n");
                    } catch (IOException ex) {
                        System.out.println("Write logs error");
                    }
                }
            }
        }
    }
}

