package dto.authorization_api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthResponse {
    private String message;
    private String accessToken;
    private String refreshToken;
    private String mobilePhone;
    private String clientStatus;
    private String idCustomer;
    private String autotransfers;
    private String detail;
    private String status;
    private String agreementID;
    private String isActive;
}