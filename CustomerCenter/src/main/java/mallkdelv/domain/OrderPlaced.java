package mallkdelv.domain;

import mallkdelv.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String productName;
    private Long CustomerId;
    private Long productId;
    private Integer qty;
    private String status;
    private Long orderId;
}
