package com.teachmeskills.lesson14.task1.constant;
/**
 * The Сonstant interface contains regular expressions for validation, and file paths.
 */
public interface Сonstant {
    String DOC_NUM = "docnum" + "\\w{9}";
    String CONTRACT = "contract" + "\\w{7}";
    String NOT_VALID = "^[^<>%$\s]*$";
    String PATH = ".\\file\\source\\documentation.txt";
    String DOC = ".\\file\\documents\\document.txt";
    String CON = ".\\file\\documents\\contract.txt";
    String ERROR_LOG = ".\\file\\logs\\error_log.txt";
}
