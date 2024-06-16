/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBSearch {
    
    Statement stmt;
    ResultSet rs;
    
    public ResultSet searchLogin(String usName) {

            try {
      stmt = DBConnection.getStatementConnection();
      String name = usName;
    //Execute the Query
    rs = stmt.executeQuery("SELECT * FROM login where username='" + name + "'");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return rs;
        }

    public ResultSet searchTrainer() {
        try{
            stmt = DBConnection.getStatementConnection();
            rs = stmt.executeQuery("SELECT * FROM trainers");
        } catch(Exception e) {

            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet searchTrainerDetailsByID(String trainerID) throws SQLException {
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM trainers WHERE trainerID = ?");
            statement.setString(1, trainerID);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            throw new SQLException("Error occurred while searching for trainers.", e);
        }
        return resultSet;
    }
    
    public ResultSet searchMembers() {
        try{
            stmt = DBConnection.getStatementConnection();
            rs = stmt.executeQuery("SELECT * FROM members");
        } catch(Exception e) {

            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet searchMemberDetailsByID(String memberID) throws SQLException {
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM members WHERE memberid = ?");
            statement.setString(1, memberID);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            throw new SQLException("Error occurred while searching for members.", e);
        }
        return resultSet;
    }
    
}

