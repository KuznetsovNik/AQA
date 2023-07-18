package dto.authorization_api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutotransfersItem {
	private int transferID;
	private String startDate;
	private String transferSum;
	private int periodicity;
	private long mobilePhone;
}
