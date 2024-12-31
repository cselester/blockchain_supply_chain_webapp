package com.block.model;

public class Compliance {
    private int id;
    private String complianceType;
    private String status;
    private String description;

    // Constructor
    public Compliance(int id, String complianceType, String status, String description) {
        this.id = id;
        this.complianceType = complianceType;
        this.status = status;
        this.description = description;
    }

    // Constructor without ID (for creating new records)
    public Compliance(String complianceType, String status, String description) {
        this.complianceType = complianceType;
        this.status = status;
        this.description = description;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComplianceType() {
        return complianceType;
    }

    public void setComplianceType(String complianceType) {
        this.complianceType = complianceType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Compliance{id=" + id + ", complianceType='" + complianceType + "', status='" + status + "', description='" + description + "'}";
    }
}
