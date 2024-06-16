/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AddTrainer;
import Model.UpdateDeleteTrainer;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TrainerController {
    
    public static void Trainer(String trainerID, String trainerName, String gender, 
        String email, String phoneNumber) {
        new AddTrainer().addTrainer(trainerID, trainerName, gender, email, phoneNumber);
        JOptionPane.showMessageDialog(null, "New Record has been inserted", 
            "Success", JOptionPane.INFORMATION_MESSAGE);
    }    
    
    public static boolean updateTrainer(String trainerID, String trainerName, String gender, String email, String phoneNumber) {
        boolean success = false;
        try {
            success = UpdateDeleteTrainer.updateTrainer(trainerID, trainerName, gender, email, phoneNumber);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return success;
    }
    
    public static boolean deleteTrainer(String trainerID) throws SQLException {
        boolean success = false;
        success = UpdateDeleteTrainer.deleteTrainer(trainerID);
        return success;
    }
}
