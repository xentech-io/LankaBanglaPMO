package io.xentech.lankabanglapmo.model;

public class ProductListModel {

    private String productName;
    private int productId;

    public ProductListModel(String productName, int productId) {
        this.productName = productName;
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String prductName) {
        this.productName = prductName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
