package mallkdelv.domain;

import mallkdelv.domain.*;
import mallkdelv.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class DeliveryReturned extends AbstractEvent {

    private Long id;
    private Long oderid;
    private Long productId;
    private Integer qty;
    private String productName;
    private String status;
}


