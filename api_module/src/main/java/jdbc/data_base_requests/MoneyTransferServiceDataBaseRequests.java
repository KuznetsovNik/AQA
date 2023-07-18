package jdbc.data_base_requests;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static jdbc.ConnectionDB.connectionDB;
import static property.BaseProperties.DB_MT_NAME;

public class MoneyTransferServiceDataBaseRequests {

    public static String getTranslationSenderId(String id) {
        String senderId = null;
        String sql = "SELECT sender_id FROM money_transfer_app_transferdetails where transfer_id = '" + id + "'";
        try (PreparedStatement preparedStatement = connectionDB.getConnection(DB_MT_NAME).prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                senderId = resultSet.getString("sender_id");
            }
            return senderId;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static boolean deleteCreditOrderById(String id) {
        String sql = "DELETE FROM money_transfer_app_transferdetails where transfer_id ='" + id + "'";
        try (PreparedStatement prepareStatement = connectionDB.getConnection(DB_MT_NAME).prepareStatement(sql)) {
            return prepareStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}