package com.block.dao;
import com.block.model.Compliance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.block.dao.ComplianceDAO;
import com.block.dao.DAOException;


class DAOException extends Exception {
    // Adding serialVersionUID to resolve the warning
    private static final long serialVersionUID = 1L;

    // Constructor that accepts both message and cause
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class ComplianceDAO {

    // Method to add a new compliance record
    public void addCompliance(Compliance compliance) throws DAOException {
        String sql = "INSERT INTO Compliance (compliance_type, status, description) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, compliance.getComplianceType());
            stmt.setString(2, compliance.getStatus());
            stmt.setString(3, compliance.getDescription());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Error inserting compliance", e);
        }
    }

    // Method to get a compliance record by ID
    public Compliance getComplianceById(int id) throws DAOException {
        String sql = "SELECT * FROM Compliance WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Compliance(rs.getInt("id"), rs.getString("compliance_type"),
                        rs.getString("status"), rs.getString("description"));
            }
        } catch (SQLException e) {
            throw new DAOException("Error fetching compliance by ID", e);
        }
        return null;
    }

    // Method to get all compliance records
    public List<Compliance> getAllCompliances() throws DAOException {
        List<Compliance> compliances = new ArrayList<>();
        String sql = "SELECT * FROM Compliance";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                compliances.add(new Compliance(rs.getInt("id"), rs.getString("compliance_type"),
                        rs.getString("status"), rs.getString("description")));
            }
        } catch (SQLException e) {
            throw new DAOException("Error fetching all compliances", e);
        }
        return compliances;
    }

    // Method to update a compliance record by ID
    public void updateCompliance(Compliance compliance) throws DAOException {
        String sql = "UPDATE Compliance SET compliance_type = ?, status = ?, description = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, compliance.getComplianceType());
            stmt.setString(2, compliance.getStatus());
            stmt.setString(3, compliance.getDescription());
            stmt.setInt(4, compliance.getId());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated == 0) {
                throw new DAOException("Compliance with ID " + compliance.getId() + " not found", null);
            }
        } catch (SQLException e) {
            throw new DAOException("Error updating compliance", e);
        }
    }

    // Method to delete a compliance record by ID
    public void deleteCompliance(int id) throws DAOException {
        String sql = "DELETE FROM Compliance WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted == 0) {
                throw new DAOException("Compliance with ID " + id + " not found", null);
            }
        } catch (SQLException e) {
            throw new DAOException("Error deleting compliance", e);
        }
    }

    public static void main(String[] args) {
        // Create an instance of ComplianceDAO
        ComplianceDAO complianceDAO = new ComplianceDAO();

        // Create a new Compliance object to insert
        Compliance newCompliance = new Compliance("Financial Audit", "Completed", "Audit for Q1 was completed successfully.");

        // Insert the compliance record into the database
        try {
            complianceDAO.addCompliance(newCompliance);
            System.out.println("Compliance inserted successfully.");
        } catch (DAOException e) {
            System.out.println("Error inserting compliance: " + e.getMessage());
            e.printStackTrace();
        }

        // Retrieve a compliance record by ID
        int idToSearch = 1;
        try {
            Compliance compliance = complianceDAO.getComplianceById(idToSearch);
            if (compliance != null) {
                System.out.println("Compliance found: " + compliance);
            } else {
                System.out.println("Compliance not found.");
            }
        } catch (DAOException e) {
            System.out.println("Error fetching compliance: " + e.getMessage());
            e.printStackTrace();
        }

        // Retrieve all compliance records from the database
        try {
            List<Compliance> compliances = complianceDAO.getAllCompliances();
            System.out.println("All compliances in the database:");
            for (Compliance c : compliances) {
                System.out.println(c);
            }
        } catch (DAOException e) {
            System.out.println("Error fetching compliances: " + e.getMessage());
            e.printStackTrace();
        }

        // Update a compliance record by ID
        try {
            Compliance complianceToUpdate = new Compliance(1, "Financial Audit", "Pending", "Audit for Q2 is yet to start.");
            complianceDAO.updateCompliance(complianceToUpdate);
        } catch (DAOException e) {
            System.out.println("Error updating compliance: " + e.getMessage());
            e.printStackTrace();
        }

        // Delete a compliance record by ID
        try {
            complianceDAO.deleteCompliance(1);
        } catch (DAOException e) {
            System.out.println("Error deleting compliance: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

