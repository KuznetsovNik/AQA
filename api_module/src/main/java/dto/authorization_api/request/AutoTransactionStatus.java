package dto.authorization_api.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AutoTransactionStatus {
    private int periodicity;
    private String startDate;
    private String expirationDate;
}