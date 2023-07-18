package jdbc.data_base_requests.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepositPojo {
    private int productId;
    private float initialAmount;
    private Boolean isAutoRenewal;
}