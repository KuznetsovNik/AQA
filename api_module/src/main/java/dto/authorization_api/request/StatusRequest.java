package dto.authorization_api.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatusRequest {
    private String status;
}