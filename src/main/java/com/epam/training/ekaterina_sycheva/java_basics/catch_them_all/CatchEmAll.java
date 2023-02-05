package com.epam.training.ekaterina_sycheva.java_basics.catch_them_all;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CatchEmAll {

    static Exception exception = new FileNotFoundException();

    public static void riskyMethod() throws Exception {
        throw exception;
    }

    /**
     *  Handles a call to a risky method that can throw different types of exceptions.
     *  IOException - wraps in an IllegalArgumentException with a message "Resource error" and throws it
     *  FileNotFoundException - wraps in an IllegalArgumentException with a message "Resource is missing" and throws it
     *  ArithmeticException or NumberFormatException - prints a message of the thrown exception to System.err and do not throw anything
     *  Any other Exceptions are not be caught
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        try {
            riskyMethod();
        }
        catch (ArithmeticException | NumberFormatException e) {
            System.err.println(e.getMessage());
        } catch (FileNotFoundException exceptionFNF) {
            throw new IllegalArgumentException("Resource is missing", exceptionFNF);
        } catch (IOException exceptionIO) {
            throw new IllegalArgumentException("Resource error", exceptionIO);
        }
    }
}
