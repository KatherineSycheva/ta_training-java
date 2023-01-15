package com.epam.training.ekaterina_sycheva.java_basics.catch_them_all;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CatchEmAll {

    //You may set another exception in this field;
    static Exception exception = new FileNotFoundException();

    public static void riskyMethod() throws Exception {
        throw exception;
    }

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
