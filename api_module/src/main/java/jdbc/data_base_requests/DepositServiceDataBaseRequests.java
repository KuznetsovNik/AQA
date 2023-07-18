package jdbc.data_base_requests;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static jdbc.ConnectionDB.connectionDB;

import jdbc.data_base_requests.pojo.DepositPojo;
import jdbc.data_base_requests.pojo.Product;

import static property.BaseProperties.DB_DEPOSIT_SERVICE_NAME;

public class DepositServiceDataBaseRequests {

    public static DepositPojo getDepositById(String id) {
        DepositPojo deposit = new DepositPojo();
        String sql = "SELECT product_id,initial_amount, is_auto_renewal FROM agreement where id = '" + id + "'";
        try (PreparedStatement preparedStatement = connectionDB.getConnection(DB_DEPOSIT_SERVICE_NAME).prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                deposit.setProductId(resultSet.getInt("product_id"));
                deposit.setInitialAmount(resultSet.getFloat("initial_amount"));
                deposit.setIsAutoRenewal(resultSet.getBoolean("is_auto_renewal"));
            }
            return deposit;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static boolean deleteDepositById(String id) {
        String sql = "delete from agreement where  id='" + id + "'";
        try (PreparedStatement prepareStatement = connectionDB.getConnection(DB_DEPOSIT_SERVICE_NAME).prepareStatement(sql)) {
            return prepareStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static Product getProductInfoById(Integer id) {
        Product product = new Product();
        String sql = "SELECT id, min_sum, max_sum, min_duration, max_duration FROM product where id = '" + id + "'";
        try (PreparedStatement preparedStatement = connectionDB.getConnection(DB_DEPOSIT_SERVICE_NAME).prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                product.setId(resultSet.getInt("id"));
                product.setMinSum(resultSet.getFloat("min_sum"));
                product.setMaxSum(resultSet.getFloat("max_sum"));
                product.setMinDuration(resultSet.getInt("min_duration"));
                product.setMaxDuration(resultSet.getInt("max_duration"));
            }
            return product;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    } public static List<String> getDepositsAccountNumberList(String userId) {
        List<String> list = new ArrayList();
        String sql = "select agreement.id, account.account_number, product.name, agreement.initial_amount, product.currency_code, agreement.start_at, agreement.end_at from product join agreement on product.id = agreement.product_id join account on agreement.account_number = account.account_number where user_id = '" + userId + "'";
        try (Statement statement = connectionDB.getConnection(DB_DEPOSIT_SERVICE_NAME).createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                list.add(resultSet.getString("account_number"));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static String getDepositAccountNumber(String user_id, String agreementId) {
        String accountNumber = "";
        String sql = "select agreement.id, account.account_number, agreement.start_at, agreement.end_at, agreement.interest_rate, agreement.initial_amount, agreement.is_auto_renewal, product.name, product.currency_code, product.is_percent_capitalization, product.withdrawal_rate, product.is_revocable, product.is_prolongation, product.is_replenishment\n" +
                "from public.product join agreement on product.id = agreement.product_id join account \n" +
                "on agreement.account_number = account.account_number \n" +
                "where account.user_id = '" + user_id + "' and agreement.id = '" + agreementId + "'";
        try (PreparedStatement preparedStatement = connectionDB.getConnection(DB_DEPOSIT_SERVICE_NAME).prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                accountNumber = resultSet.getString("account_number");
            }
            return accountNumber;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}