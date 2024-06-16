/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Statement;

public class AddTrainer {
    Statement stmt;

    public void addTrainer(String trainerID, String trainerName, String gender, 
        String email, String phoneNumber) {
        try {
            stmt = DBConnection.getStatementConnection();
            stmt.executeUpdate(
                "INSERT INTO trainers (trainerID, trainerName, gender, email, "
                        + "phonenumber) VALUES('"+ trainerID + "', '"
                        + trainerName + "', '"+ gender + "', '"+ email + "', '"
                        + phoneNumber + "')"
            );
        System.out.println("Trainer Record added Successfull");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
