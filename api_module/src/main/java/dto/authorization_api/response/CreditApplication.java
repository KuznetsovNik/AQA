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
public class CreditApplication {
    private String id;
    @JsonAlias("period_month")
    private String periodMonth;
    private String status;
    private String amount;
    @JsonAlias("creation_date")
    private String creationDate;
    @JsonAlias("average_monthly_income")
    private String averageMonthlyIncome;
    @JsonAlias("average_monthly_expenditure")
    private String averageMonthlyExpenditure;
    @JsonAlias("employer_identification_number")
    private String employerIdentificationNumber;
    @JsonAlias("product_id")
    private String productId;
}
