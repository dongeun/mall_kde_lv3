package mallkdelv.domain;

import mallkdelv.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class DeliveryCompleted extends AbstractEvent {

    private Long id;
    private Long oderid;
    private Long productId;
    private Integer qty;
    private String productName;
    private String status;
}
