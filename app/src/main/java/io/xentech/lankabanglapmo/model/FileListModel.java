package io.xentech.lankabanglapmo.model;

public class FileListModel {

    private String clientName, clientDesignation, companyName, branchName, productName, mobileNo, fileId;

    public FileListModel(String clientName, String clientDesignation, String companyName, String branchName, String productName, String mobileNo, String fileId) {
        this.clientName = clientName;
        this.clientDesignation = clientDesignation;
        this.companyName = companyName;
        this.branchName = branchName;
        this.productName = productName;
        this.mobileNo = mobileNo;
        this.fileId = fileId;
    }


    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientDesignation() {
        return clientDesignation;
    }

    public void setclientDesignation(String clientDesignation) {
        clientDesignation = clientDesignation;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

}
