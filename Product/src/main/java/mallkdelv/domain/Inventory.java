package mallkdelv.domain;

import mallkdelv.domain.StockDecreased;
import mallkdelv.domain.StockIncreased;
import mallkdelv.ProductApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Inventory_table")
@Data

public class Inventory  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String productName;
    
    
    
    
    
    private Integer stock;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private Long oderId;

    @PostPersist
    public void onPostPersist(){


        StockDecreased stockDecreased = new StockDecreased(this);
        stockDecreased.publishAfterCommit();

    }
    @PostUpdate
    public void onPostUpdate(){


        StockIncreased stockIncreased = new StockIncreased(this);
        stockIncreased.publishAfterCommit();

    }

    public static InventoryRepository repository(){
        InventoryRepository inventoryRepository = ProductApplication.applicationContext.getBean(InventoryRepository.class);
        return inventoryRepository;
    }




    public static void stockDecrease(DeliveryCompleted deliveryCompleted){

        /** Example 1:  new item 
        Inventory inventory = new Inventory();
        repository().save(inventory);

        StockIncreased stockIncreased = new StockIncreased(inventory);
        stockIncreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryCompleted.get???()).ifPresent(inventory->{
            
            inventory // do something
            repository().save(inventory);

            StockIncreased stockIncreased = new StockIncreased(inventory);
            stockIncreased.publishAfterCommit();

         });
        */

        
    }
    public static void stockINcrease(DeliveryReturned deliveryReturned){

        /** Example 1:  new item 
        Inventory inventory = new Inventory();
        repository().save(inventory);

        StockDecreased stockDecreased = new StockDecreased(inventory);
        stockDecreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryReturned.get???()).ifPresent(inventory->{
            
            inventory // do something
            repository().save(inventory);

            StockDecreased stockDecreased = new StockDecreased(inventory);
            stockDecreased.publishAfterCommit();

         });
        */

        
    }


}
