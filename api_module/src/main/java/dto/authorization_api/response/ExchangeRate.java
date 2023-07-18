package dto.authorization_api.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRate {
    @JsonAlias("updated_at")
    private String updatedAt;
    private String name;
    private String currency_code;
    private String unit;
    @JsonAlias("buying_rate")
    private String buyingRate;
    @JsonAlias("selling_rate")
    private String sellingRate;
}