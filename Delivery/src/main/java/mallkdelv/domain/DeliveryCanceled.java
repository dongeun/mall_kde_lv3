package mallkdelv.domain;

import mallkdelv.domain.*;
import mallkdelv.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class DeliveryCanceled extends AbstractEvent {

    private Long id;
    private Long oderid;
    private Long productId;
    private Integer qty;
    private String productName;
    private String status;

    public DeliveryCanceled(Delivery aggregate){
        super(aggregate);
    }
    public DeliveryCanceled(){
        super();
    }
}
