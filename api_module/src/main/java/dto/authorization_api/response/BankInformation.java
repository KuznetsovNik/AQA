package dto.authorization_api.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BankInformation {
    @JsonProperty("bank_branch_type")
    private String bankBranchType;
    @JsonProperty("branch_number")
    private String branch_number;
    @JsonProperty("branch_coordinates")
    private String branchCoordinates;
    private String city;
    @JsonProperty("branch_address")
    private String branchAddress;
    @JsonProperty("is_closed")
    private String isClosed;
    @JsonProperty("opening_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private Date openingTime;
    @JsonProperty("losing_time")
    @JsonFormat(pattern = "HH:mm:ss")
    private Date closingTime;
    @JsonProperty("work_at_weekends")
    private String workAtWeekends;
    @JsonProperty("cash_withdraw")
    private String cashWithdraw;
    @JsonProperty("money_transfer")
    private String moneyTransfer;
    @JsonProperty("accept_payment")
    private String acceptPayment;
    @JsonProperty("currency_exchange")
    private String currencyExchange;
    @JsonProperty("exotic_currency")
    private String exoticCurrency;
    private String ramp;
    @JsonProperty("replenish_card")
    private String replenishCard;
    @JsonProperty("replenish_account")
    private String replenishAccount;
    private String consultation;
    private String insurance;
}
