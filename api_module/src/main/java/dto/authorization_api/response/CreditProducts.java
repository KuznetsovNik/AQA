package dto.authorization_api.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditProducts {
    private String id;
    @JsonAlias ("product_name")
    private String productName;
    @JsonAlias("min_sum")
    private String minSum;
    @JsonAlias("max_sum")
    private String maxSum;
    @JsonAlias("currency_code")
    private String currencyCode;
    @JsonAlias("min_interest_rate")
    private String minInterestRate;
    @JsonAlias("max_interest_rate")
    private String maxInterestRate;
    @JsonAlias("need_guarantees")
    private String needGuarantees;
    @JsonAlias("delivery_in_cash")
    private String deliveryInCash;
    @JsonAlias("early_payment")
    private String earlyPayment;
    @JsonAlias("min_period_month")
    private String minPeriodMonth;
    @JsonAlias("max_period_month")
    private String maxPeriodMonth;
    @JsonAlias("product_is_active")
    private String productIsActive;
    @JsonAlias("product_details")
    private String productDetails;
    @JsonAlias("calculation_mode")
    private String calculationMode;
    @JsonAlias("grace_period_month")
    private String gracePeriodMonth;
    @JsonAlias("need_income_details")
    private String needIncomeDetails;
    @JsonAlias("rate_is_adjustable")
    private String rateIsAdjustable;
    @JsonAlias("rate_base")
    private String rateBase;
    @JsonAlias("rate_fix_part")
    private String rateFixPart;
    @JsonAlias("increased_rate")
    private String increasedRate;
    @JsonAlias("creditType")
    private String credit_type;
}