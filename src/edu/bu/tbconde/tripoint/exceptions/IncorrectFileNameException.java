package edu.bu.tbconde.tripoint.exceptions;

/**This class creates a custom exception to catch if the cause of the exception is an incorrect file name*/
public class IncorrectFileNameException extends Exception{
    /* custom exceptions are useful for catching and providing specific treatment to a subset of java exceptions.
    * source: https://www.baeldung.com/java-new-custom-exception
    * */
    public IncorrectFileNameException(String e, Throwable err) {
        super(e, err);
    }
    public IncorrectFileNameException(String e) {
        super(e);
    }
}
