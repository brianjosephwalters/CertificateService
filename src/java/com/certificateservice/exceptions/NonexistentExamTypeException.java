package com.certificateservice.exceptions;

import javax.xml.ws.WebFault;

/**
 *
 * @author bjw
 */

@WebFault(  name = "NonexistentExamTypeException",
            targetNamespace="http://certificateservice.com/")
public class NonexistentExamTypeException extends Exception {
    String examTypeCode;
    
    public NonexistentExamTypeException(String examTypeCode) {
        this.examTypeCode = examTypeCode;
    }
    
    public String getExamTypeCode() {
        return this.examTypeCode;
    }
    
    @Override
    public String getMessage() {
        return "Exam Type does not exist: " + this.examTypeCode;
    }
}
