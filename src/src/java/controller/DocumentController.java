/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.DocumentDAO;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.servlet.http.Part;
import java.io.Serializable;
import entity.Document;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;

/**
 *
 * @author kopuk
 */
@Named(value = "documentController")
@SessionScoped
public class DocumentController implements Serializable {

    /**
     * Creates a new instance of DocumentController
     */
    private Document document;
    private List<Document> documentList;
    private DocumentDAO documentDAO;
    private Part doc;
    
    private final String uploadTo = "User/kopuk/Documents/upload/";
    public DocumentController() {
    }
    
    public void upload(){
        
        try {
            InputStream input = doc.getInputStream();
            File f = new File(uploadTo+doc.getSubmittedFileName());
            Files.copy(input, f.toPath());
            
            
            document = this.getDocument();
            document.setFilePath(f.getParent());
            document.setFileName(f.getName());
            document.setFileType(doc.getContentType());
            System.out.println("**************"+document.getFilePath()+"********************");
            this.getDocumentDAO().insert(document);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Document getDocument() {
        if (this.document == null) {
            this.document = new Document();
        }
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public List<Document> getDocumentList() {
        this.documentList = this.getDocumentDAO().findAll();
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }

    public DocumentDAO getDocumentDAO() {
        if (this.documentDAO == null) {
            this.documentDAO = new DocumentDAO();
        }
        return documentDAO;
    }

    public void setDocumentDAO(DocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }

    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }

    public String getUploadTo() {
        return uploadTo;
    }
    

    
}
