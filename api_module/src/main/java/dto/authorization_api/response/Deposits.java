package dto.authorization_api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Deposits {

    private int agreementId;
    private String accountNumber;
    private String startDate;
    private String endDate;
    private int interestRate;
    private int initAmount;
    private boolean autoRenewal;
    private String name;
    private String currency;
    private boolean percentCapitalization;
    private int withdrawalRate;
    private boolean isRevocable;
    private boolean isProlongation;
    private boolean isReplenishment;
}