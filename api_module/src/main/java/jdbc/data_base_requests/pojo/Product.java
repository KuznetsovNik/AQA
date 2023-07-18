package jdbc.data_base_requests.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product {
    private int id;
    private float minSum;
    private float maxSum;
    private int minDuration;
    private int maxDuration;
}