package dto.authorization_api.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoanInformation {
        private String id;
        private String name;
        @JsonAlias("principal_debt")
        private String principalDebt;
        @JsonAlias("credit_limit")
        private String creditLimit;
        @JsonAlias("currency_code")
        private String currency_code;
        @JsonAlias("closing_date")
        private String closingDate;
        @JsonAlias("early_repayment_notification_date")
        private String earlyRepaymentNotificationDate;
}