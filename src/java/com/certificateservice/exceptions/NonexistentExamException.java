package com.certificateservice.exceptions;

import javax.xml.ws.WebFault;

/**
 *
 * @author bjw
 */
@WebFault(  name = "NonexistentExamException",
            targetNamespace = "http://certificateservice.com/")
public class NonexistentExamException extends Exception {
    String examCode;
    
    public NonexistentExamException (String examCode) {
        this.examCode = examCode;
    }
    
    public String getExamCode() {
        return this.examCode;
    }
    
    @Override
    public String getMessage() {
        return "Exam does not exist: " + this.examCode;
    }
}
