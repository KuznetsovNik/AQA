package jdbc.data_base_requests;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static jdbc.ConnectionDB.connectionDB;
import static property.BaseProperties.DB_INFO_SERVICE_NAME;

public class InfoServiceDataBaseRequests {

    public static List<String> getBranchNumbersList() {
        List<String> list = new ArrayList();
        String sql = "SELECT branch_number FROM info_app_bankbranch";
        try (Statement statement = connectionDB.getConnection(DB_INFO_SERVICE_NAME).createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                list.add(resultSet.getString("branch_number"));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public static List<String> getCurrencyList() {
        List<String> list = new ArrayList();
        String sql = "SELECT currency_code FROM info_app_currencycode";
        try (Statement statement = connectionDB.getConnection(DB_INFO_SERVICE_NAME).createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                list.add(resultSet.getString("currency_code"));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}