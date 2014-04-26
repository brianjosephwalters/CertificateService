package com.certificateservice;

import com.certificateservice.business.CertificateServiceImpl;
import com.certificateservice.exceptions.NonexistentCertificateException;
import com.certificateservice.exceptions.NonexistentExamTypeException;
import com.certificateservice.models.Certificate;
import com.certificateservice.models.Exam;
import com.certificateservice.models.ExamType;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 
 * @author bjw
 */
@WebService(serviceName = "CertificateService")
public class CertificateService {
    private CertificateServiceImpl impl;
    
    public CertificateService () {
        this.impl = new CertificateServiceImpl();
    }
    
    @WebMethod(operationName = "getCertificate")
    public Certificate getCertificate (
            @WebParam(name = "certificateCode") String certificateCode) 
            throws NonexistentCertificateException {
        Certificate certificate;
        try {
            certificate = this.impl.getCertificate(certificateCode);
        } catch (NonexistentCertificateException e) {
            throw e;
        }
        return certificate;
    }
    
    @WebMethod(operationName = "getAllCertificates")
    public List<Certificate> getAllCertificates() {
        return this.impl.getAllCertificates();
    }
    
    @WebMethod(operationName = "getExamsForCertificate")
    public List<Exam> getExamsForCertificate(
            @WebParam(name="certificateCode") String certificateCode) {
        return this.impl.getExamsForCertificate(certificateCode);
    }
    
    @WebMethod(operationName = "getAllUpcomingExamsForCertificate")
    public List<Exam> getAllUpcomingExamsForCertificate(
            @WebParam(name = "certificateCode") String certificateCode) {
        return this.impl.getAllUpcomingExamsForCertificate(certificateCode);
    }
    
    @WebMethod(operationName = "getExamType")
    public ExamType getExamType(
            @WebParam(name = "examTypeCode") String examTypeCode) 
            throws NonexistentExamTypeException {
        ExamType examType;
        try {
            examType = this.impl.getExamType(examTypeCode);
        } catch (NonexistentExamTypeException e) {
            throw e;
        }
        return examType;
    }
    
    @WebMethod(operationName = "getExamTypeForCertificate")
    public List<ExamType> getExamTypeForCertificate(
            @WebParam(name = "certificateCode") String certificateCode) {
        return this.impl.getExamTypeForCertificate(certificateCode);
    }
    @WebMethod(operationName = "getAllExamTypes")
    public List<ExamType> getAllExamTypes() {
        return this.impl.getAllExamTypes();
    }
}
