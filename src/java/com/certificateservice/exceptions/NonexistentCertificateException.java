package com.certificateservice.exceptions;

import javax.xml.ws.WebFault;

/**
 *
 * @author bjw
 */
@WebFault(  name = "NonexistentCertificateException",
            targetNamespace = "http://certificateservice.com/")
public class NonexistentCertificateException extends Exception {
    String certificateCode;

    public NonexistentCertificateException(String certificateCode) {
        this.certificateCode = certificateCode;
    }
    
    public String getCertificatCode() {
        return this.certificateCode;
    }

    @Override
    public String getMessage() {
        return "Certificate does not exist: " + this.certificateCode;
    }
}
