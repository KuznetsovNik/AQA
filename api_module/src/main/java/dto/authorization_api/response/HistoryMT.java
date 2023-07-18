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
public class HistoryMT {
    private String transferID;
    private String transferType;
    private String transferSum;
    private String currencyFrom;
    private String createdAt;
    private String status;
}