package dto.authorization_api.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MoneyTransferRequest {
    private long senderCardNumber;
    private int transferType;
    private String transferSum;
    private String currencyFrom;
    private String currencyTo;
    private int payeeAccountNumber;
    private String commission;
    private String purpose;
    private int transferSystem;
    private String currencyExchange;
    private int authorizationCode;
    private String exchSum;
    private String exchRate;
    private String mobilePhone;
}