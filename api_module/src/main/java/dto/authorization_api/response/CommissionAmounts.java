package dto.authorization_api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommissionAmounts {
    private String minCommission;
    private String maxCommission;
    private String commissionPercent;
    private String minTransferSum;
    private String maxTransferSum;
}
