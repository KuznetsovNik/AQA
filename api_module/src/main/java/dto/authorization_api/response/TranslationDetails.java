package dto.authorization_api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TranslationDetails {
    private String transferType;
    private String transferSum;
    private String currencyFrom;
    private String currencyTo;
    private String transferExchangeSum;
    private String commission;
    private String message;
    private String isAuto;
    private String isFarourite;
    private String purpose;
    private String status;
    private String createdAt;
    private String updatedAt;
    private String senderCardNumber;
    private String payeeCardNumber;
    private String mobilePhone;
}
