package com.block.dao;

import com.block.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public void addUser(User user) {
        String sql = "INSERT INTO Users (username, password, role) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM Users WHERE username = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("username"),
                        rs.getString("password"), rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM Users";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("username"),
                        rs.getString("password"), rs.getString("role")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Update user details
    public void updateUser(User user) {
        String sql = "UPDATE Users SET username = ?, password = ?, role = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());
            stmt.setInt(4, user.getId());  // Update by ID
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("User updated successfully.");
            } else {
                System.out.println("User with ID " + user.getId() + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        // Create an instance of UserDAO
        UserDAO userDAO = new UserDAO();

        // Create a new User object to insert
        User newUser = new User("john_doe", "password123", "admin");

        // Insert the user into the database
        try {
            userDAO.addUser(newUser);
            System.out.println("User inserted successfully.");
        } catch (Exception e) {
            System.out.println("Error inserting user: " + e.getMessage());
        }

        // Retrieve a user by username
        String usernameToSearch = "john_doe";
        try {
            User user = userDAO.getUserByUsername(usernameToSearch);
            if (user != null) {
                System.out.println("User found: " + user);
                
                // Update the user by ID
                user.setPassword("newpassword456");  // Update password
                user.setRole("user");  // Update role
                userDAO.updateUser(user);  // Update user in the database
            } else {
                System.out.println("User not found.");
            }
        } catch (Exception e) {
            System.out.println("Error fetching user: " + e.getMessage());
        }

        // Retrieve all users from the database
        try {
            List<User> users = userDAO.getAllUsers();
            System.out.println("All users in the database:");
            for (User u : users) {
                System.out.println(u);
            }
        } catch (Exception e) {
            System.out.println("Error fetching users: " + e.getMessage());
        }
    }

}
