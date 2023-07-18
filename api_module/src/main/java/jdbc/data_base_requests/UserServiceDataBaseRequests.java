package jdbc.data_base_requests;

import model.entity.NewUserRegistrationModel;
import model.DocType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static constant.UserDataRowsConstants.*;
import static jdbc.ConnectionDB.connectionDB;
import static property.BaseProperties.DB_USER_SERVICE_NAME;

public class UserServiceDataBaseRequests {

    public static String getClientNameById(String id) {
        String verificationCode = "";
        String sql = "SELECT * FROM db_client WHERE id='" + id + "'";
        try (Statement statement = connectionDB.getConnection(DB_USER_SERVICE_NAME).createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                String last_name = resultSet.getString("last_name");
                System.out.println(last_name);
            }
            return verificationCode;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static NewUserRegistrationModel getClientByPhoneNumber(String phoneNumber) {
        NewUserRegistrationModel user = NewUserRegistrationModel.getExemplarWithEmptyFields(DocType.PASSPORT_BY);
        String sql = "select * from user_app_contacts join user_app_client using(client_id) join user_app_document_data using(client_id) join user_app_user_profile using(client_id) where mobile_phone = '" + phoneNumber + "'";
        try (Statement statement = connectionDB.getConnection(DB_USER_SERVICE_NAME).createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                user.setClientId(resultSet.getString(CLIENT_ID));
                user.setCountryCode(resultSet.getString(COUNTRY_CODE));
                user.setMobilePhone(resultSet.getString(MOBILE_PHONE));
                user.setPassword(resultSet.getString(PASSWORD));
                user.setSecurityQuestion(resultSet.getString(SECURITY_QUESTION));
                user.setSecurityAnswer(resultSet.getString(SECURITY_ANSWER));
                user.setEmail(resultSet.getString(EMAIL));
                user.setFirstName(resultSet.getString(FIRST_NAME));
                user.setLastName(resultSet.getString(LAST_NAME));
                user.setPatronymic(resultSet.getString(PATRONYMIC));
                user.setDocType(resultSet.getString(DOC_TYPE + "_id"));
                user.setDocumentNumber(resultSet.getString(DOCUMENT_NUMBER));
                user.setIdentificationNumber(resultSet.getString(IDENTIFICATION_NUMBER));
                user.setNationality(resultSet.getString(NATIONALITY));
                user.setIssuanceDate(resultSet.getString(ISSUANCE_DATE));
                user.setExpiryDate(resultSet.getString(EXPIRY_DATE));
                user.setBirthday(resultSet.getString(BIRTH_DATE));
                user.setSmsNotification(resultSet.getBoolean(SMS_NOTIFICATION));
                user.setPushNotification(resultSet.getBoolean(PUSH_NOTIFICATION));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void deleteUserDataFromDb(String userPhoneNumber, String userDocumentNumber) {
        deleteUserByPhoneNumber(userPhoneNumber);
        deleteUserByDocumentNumber(userDocumentNumber);
    }

    private static boolean deleteUserByDocumentNumber(String documentNumber) {
        String sql = "delete from user_app_document_data where document_number = '" + documentNumber + "'";
        try (PreparedStatement prepareStatement = connectionDB.getConnection(DB_USER_SERVICE_NAME).prepareStatement(sql)) {
            return prepareStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static boolean deleteUserByPhoneNumber(String phoneNumber) {
        String sql = "delete from user_app_contacts where mobile_phone = '" + phoneNumber + "'";
        try (PreparedStatement prepareStatement = connectionDB.getConnection(DB_USER_SERVICE_NAME).prepareStatement(sql)) {
            return prepareStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}