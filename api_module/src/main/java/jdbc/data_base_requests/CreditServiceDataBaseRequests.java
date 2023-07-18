package jdbc.data_base_requests;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static jdbc.ConnectionDB.connectionDB;
import static property.BaseProperties.DB_CREDIT_SERVICE_NAME;

public class CreditServiceDataBaseRequests {

    public static List<String> getLeanList(String id) {
        List<String> list = new ArrayList();
        String sql = "SELECT product_name FROM credit_app_creditproduct " +
                "JOIN  credit_app_credit c ON credit_app_creditproduct.id=c.grace_period\n" +
                "WHERE c.id='" + id + "'";
        try (PreparedStatement preparedStatement = connectionDB.getConnection(DB_CREDIT_SERVICE_NAME).prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                list.add(resultSet.getString("product_name"));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static List<String> getCreditProductsNameList() {
        List<String> list = new ArrayList();
        String sql = "SELECT product_name  FROM credit_app_creditproduct";
        try (Statement statement = connectionDB.getConnection(DB_CREDIT_SERVICE_NAME).createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                list.add(resultSet.getString("product_name"));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static String getCreditNameByCreditId(String id) {
        String productName = "";
        String sql = "SELECT product_name FROM credit_app_creditproduct JOIN credit_app_credit\n" +
                "    ON credit_app_creditproduct.id = credit_app_credit.grace_period\n" +
                "WHERE credit_app_credit.id='" + id + "'";
        try (PreparedStatement preparedStatement = connectionDB.getConnection(DB_CREDIT_SERVICE_NAME).prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                productName = resultSet.getString("product_name");
            }
            return productName;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static String getCreditPeriodMonthFromCreditOrderById(String id) {
        String periodMonth = "";
        String sql = "SELECT * FROM credit_app_creditorder WHERE id ='" + id + "'";
        try (PreparedStatement preparedStatement = connectionDB.getConnection(DB_CREDIT_SERVICE_NAME).prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                periodMonth = resultSet.getString("period_month");
            }
            return periodMonth;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static boolean deleteCreditOrderById(String id) {
        String sql = "DELETE FROM credit_app_creditorder WHERE id ='" + id + "'";
        try (PreparedStatement prepareStatement = connectionDB.getConnection(DB_CREDIT_SERVICE_NAME).prepareStatement(sql)) {
            return prepareStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}