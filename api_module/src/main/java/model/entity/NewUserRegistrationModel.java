package model.entity;

import helper.DateHelper;
import helper.RandomHelper;
import helper.RandomUserDataHelper;
import lombok.Builder;
import lombok.Data;
import model.DateFormat;
import model.DocType;
import model.Location;
import model.Nationality;

import java.util.Locale;

@Data
@Builder
public class NewUserRegistrationModel {

    private String clientId;
    private String countryCode;
    private String mobilePhone;
    private String password;
    private String securityQuestion;
    private String securityAnswer;
    private String email;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String docType;
    private String documentNumber;
    private String identificationNumber;
    private String nationality;
    private String issuanceDate;
    private String expiryDate;
    private String birthday;
    private boolean smsNotification;
    private boolean pushNotification;

    public static NewUserRegistrationModel getExemplarWithRandomData(Location location, DocType docType) {
        int actualYear = DateHelper.getActualYear();
        DateFormat dateFormat = DateFormat.yyyy_MM_dd;
        String randomPassword = String.format("%s%s%s",
                RandomHelper.randomString(5).toUpperCase(Locale.ROOT),
                RandomHelper.randomNumeric(5),
                RandomHelper.randomString(5));
        NewUserRegistrationModelBuilder builder = NewUserRegistrationModel.builder()
                .countryCode(location.getCode())
                .mobilePhone(RandomUserDataHelper.generateRandomTelephoneNumber(location))
                .password(randomPassword)
                .securityQuestion(RandomHelper.randomString(20))
                .securityAnswer(RandomHelper.randomString(5))
                .email(RandomUserDataHelper.generateRandomEmail())
                .firstName(RandomUserDataHelper.getRandomFirstName())
                .lastName(RandomUserDataHelper.getRandomSurname())
                .patronymic(RandomUserDataHelper.getRandomPatronymic())
                .docType(docType.getCode())
                .documentNumber(RandomUserDataHelper.generateRandomDocumentNumber(docType))
                .nationality(RandomHelper.getRandomEnumExemplar(Nationality.values()).getNationality())
                .issuanceDate(RandomHelper.randomDate(actualYear - 5, actualYear - 1, dateFormat))
                .birthday(RandomHelper.randomDate(actualYear - 30, actualYear - 20, dateFormat));
        if (docType == DocType.PASSPORT_BY || docType == DocType.RESIDENT_CARD_BY) {
            return builder
                    .expiryDate(RandomHelper.randomDate(actualYear + 1, actualYear + 5, dateFormat))
                    .identificationNumber(RandomUserDataHelper.generateRandomIdentificationNumber())
                    .build();
        } else if (docType == DocType.RESIDENT_CARD_RU) {
            return builder
                    .expiryDate(RandomHelper.randomDate(actualYear + 1, actualYear + 5, dateFormat))
                    .build();
        } else {
            return builder.build();
        }
    }

    public static NewUserRegistrationModel getExemplarWithEmptyFields(DocType docType) {
        NewUserRegistrationModelBuilder builder = NewUserRegistrationModel.builder()
                .countryCode(null)
                .mobilePhone(null)
                .password(null)
                .securityQuestion(null)
                .securityAnswer(null)
                .email(null)
                .firstName(null)
                .lastName(null)
                .patronymic(null)
                .docType(null)
                .documentNumber(null)
                .nationality(null)
                .issuanceDate(null)
                .birthday(null);
        if (docType == DocType.PASSPORT_BY || docType == DocType.RESIDENT_CARD_BY) {
            return builder
                    .expiryDate(null)
                    .identificationNumber(null)
                    .build();
        } else if (docType == DocType.RESIDENT_CARD_RU) {
            return builder
                    .expiryDate(null)
                    .build();
        } else {
            return builder.build();
        }
    }
}