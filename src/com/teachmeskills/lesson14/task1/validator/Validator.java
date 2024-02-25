package com.teachmeskills.lesson14.task1.validator;

import com.teachmeskills.lesson14.task1.constant.Сonstant;

import java.io.*;
/**
 * The Validator class contains the validator method for checking whether the source numbers of documents and contracts match. Sorts by matching files
 */
public class Validator {
    public static void validator(String path) {
        File dir = new File(path);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(dir));
        } catch (Exception e) {
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
            if (!line.matches(Сonstant.CONTRACT) && !line.matches(Сonstant.DOC_NUM)) {
                try (FileWriter writer = new FileWriter(Сonstant.EXECUTION_LOG, true)) {
                    if (line.length() < 15 || line.length() > 15) {
                        writer.write("Not valid number: " + line + " length does not match" + "\n");
                    }
                    if (line.matches(Сonstant.NOT_VALID)) {
                        writer.write("Not valid number: " + line + " there is a special symbol or space" + "\n");
                    }
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


