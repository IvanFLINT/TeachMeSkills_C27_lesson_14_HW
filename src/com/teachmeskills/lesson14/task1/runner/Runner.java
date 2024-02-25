package com.teachmeskills.lesson14.task1.runner;

import com.teachmeskills.lesson14.task1.validator.Validator;

import java.io.*;
import java.util.Scanner;

/**
 * The Runner class is located in the main method, which calls the validator method
 * Requests the path to the file. Source path: .\file\source\documentation.txt
 */

public class Runner {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String path = sc.nextLine();
        try {
            Validator.validator(path);
        } catch (Exception e) {
            System.out.println("File path not found");
        }
    }
}

