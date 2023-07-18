package dto.authorization_api.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthRequest {
    private String code;
    private String login;
    private String password;
    private String type;
    ArrayList<Exception> exceptions;
}