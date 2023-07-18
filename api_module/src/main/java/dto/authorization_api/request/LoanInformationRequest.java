package dto.authorization_api.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoanInformationRequest {

    private String period_month;
    private String amount;
    private String average_monthly_income;
    private String average_monthly_expenditure;
    private String employer_identification_number;
    private String product_id;
}
