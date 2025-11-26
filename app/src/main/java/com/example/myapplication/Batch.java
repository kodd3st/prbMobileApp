package com.example.myapplication;

public class Batch {
    private String batchId;
    private String status;
    private String productType;

    public Batch(String batchId, String status, String productType) {
        this.batchId = batchId;
        this.status = status;
        this.productType = productType;
    }
    public String getBatchId() {
        return batchId;
    }

    public String getStatus() {
        return status;
    }

    public String getProductType() {
        return productType;
    }
}
