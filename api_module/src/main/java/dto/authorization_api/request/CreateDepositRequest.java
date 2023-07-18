package dto.authorization_api.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class CreateDepositRequest {

    private String productID;
    private String initialAmount;
    private String cardNumber;
    private String accountNumber;
    private String autoRenewal;
    private String duration;
}