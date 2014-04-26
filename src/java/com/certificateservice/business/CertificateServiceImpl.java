/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.certificateservice.business;

import com.certificateservice.db.CertificateDB;
import com.certificateservice.exceptions.NonexistentCertificateException;
import com.certificateservice.exceptions.NonexistentExamTypeException;
import com.certificateservice.models.Certificate;
import com.certificateservice.models.Exam;
import com.certificateservice.models.ExamType;
import com.certificateservice.queries.CertificateQueries;
import com.certificateservice.queries.ExamQueries;
import com.certificateservice.queries.ExamTypeQueries;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author bjw
 */
public class CertificateServiceImpl {
    
    public Certificate getCertificate(String certificateCode) 
            throws NonexistentCertificateException {
        CertificateQueries queries = new CertificateQueries(CertificateDB.dbConnection());
        Certificate certificate = null;
        try {
            certificate = queries.getCertificate(certificateCode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (certificate == null) {
            throw new NonexistentCertificateException(certificateCode);
        }
        return certificate;
    }
    
    public List<Certificate> getAllCertificates() {
        CertificateQueries queries = new CertificateQueries(CertificateDB.dbConnection());
        List<Certificate> list = null;
        try {
            list = queries.getAllCertificates();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<Exam> getExamsForCertificate(String certificateCode) {
        ExamQueries queries = new ExamQueries(CertificateDB.dbConnection());
        List<Exam> list = null;
        try {
            list = queries.getExamsForCertificate(certificateCode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<Exam> getAllUpcomingExamsForCertificate(String certificateCode) {
        ExamQueries queries = new ExamQueries(CertificateDB.dbConnection());
        List<Exam> list = null;
        try {
            list = queries.getAllUpcomingExams(certificateCode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ExamType getExamType(String examTypeCode) 
            throws NonexistentExamTypeException {
        ExamTypeQueries queries = new ExamTypeQueries(CertificateDB.dbConnection());
        ExamType examType = null;
        try {
            examType = queries.getExamType(examTypeCode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (examType == null) {
            throw new NonexistentExamTypeException(examTypeCode);
        }
        
        return examType;
    }
    
    public List<ExamType> getAllExamTypes() {
        ExamTypeQueries queries = new ExamTypeQueries(CertificateDB.dbConnection());
        List<ExamType> list = null;
        try {
            list = queries.getAllExamTypes();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<ExamType> getExamTypeForCertificate(String certificateCode) {
        ExamTypeQueries queries = new ExamTypeQueries(CertificateDB.dbConnection());
        List<ExamType> list = null;
        try {
            list = queries.getExamTypeForCertificate(certificateCode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
