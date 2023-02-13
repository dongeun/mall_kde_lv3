package mallkdelv.domain;

import mallkdelv.domain.*;
import mallkdelv.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String productName;
    private Long customerId;
    private Long productId;
    private Integer qty;
    private String status;
    private Long orderId;
}


