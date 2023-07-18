package dto.authorization_api.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(Include.NON_EMPTY)
public class SettingsRequest {
    private Object notificationStatusSms;
    private Object notificationStatusPush;
    private String securityQuestion;
    private String securityAnswer;
    private String password;
    private String newPassword;
}