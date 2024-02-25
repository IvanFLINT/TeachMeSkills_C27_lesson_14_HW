package com.teachmeskills.lesson14.task1.service;

import com.teachmeskills.lesson14.task1.constant.Сonstant;

import java.io.*;

public class Service {
    public static void service() {
        File dir = new File(Сonstant.PATH);
        BufferedReader br = null;
        try{
        br = new BufferedReader(new FileReader(dir));
        }catch (Exception e){
            System.out.println("File does not exist");
            try (FileWriter writer = new FileWriter(Сonstant.ERROR_LOG, true)) {
                writer.write("File does not exist" + "\n");
            } catch (Exception ex) {
                System.out.println("Write error");
            }
        }
        String line = null;
        while (true) {
            try {
                if (!((line = br.readLine()) != null)) break;
            } catch (Exception ex1) {
                System.out.println("The file is unreadable");
                try (FileWriter writer = new FileWriter(Сonstant.ERROR_LOG, true)) {
                    writer.write("The file is unreadable" + "\n");
                } catch (Exception ex2) {
                    System.out.println("Write error");
                }
            }
            if (line.matches(Сonstant.DOC_NUM)) {
                try (FileWriter writer = new FileWriter(Сonstant.DOC, true)) {
                    writer.write("Valid document number: " + line + "\n");
                } catch (Exception ex1) {
                    System.out.println("Write error");
                    try (FileWriter writer = new FileWriter(Сonstant.ERROR_LOG, true)) {
                        writer.write("Write error" + "\n");
                    } catch (Exception ex2) {
                        System.out.println("Write error");
                    }
                }
            }
            if (line.matches(Сonstant.CONTRACT)) {
                try (FileWriter writer = new FileWriter(Сonstant.CON, true)) {
                    writer.write("Valid contract number: " + line + "\n");
                } catch (Exception ex1) {
                    System.out.println("Write error");
                    try (FileWriter writer = new FileWriter(Сonstant.ERROR_LOG, true)) {
                        writer.write("Write error" + "\n");
                    } catch (Exception ex2) {
                        System.out.println("Write error");
                    }
                }
            }
            if(!line.matches(Сonstant.CONTRACT) && !line.matches(Сonstant.DOC_NUM)){
                try (FileWriter writer = new FileWriter(Сonstant.NOT_VALID, true)) {
                    writer.write("Not valid number: " + line + "\n");
                } catch (Exception ex1) {
                    System.out.println("Write error");
                    try (FileWriter writer = new FileWriter(Сonstant.ERROR_LOG, true)) {
                        writer.write("Write error" + "\n");
                    } catch (Exception ex2) {
                        System.out.println("Write error");
                    }
                }

            }
        }
    }
}


