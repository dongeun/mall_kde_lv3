package mallkdelv.infra;

import mallkdelv.domain.*;
import mallkdelv.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MypageViewHandler {

    @Autowired
    private MypageRepository mypageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1 (@Payload OrderPlaced orderPlaced) {
        try {

            if (!orderPlaced.validate()) return;

            // view 객체 생성
            Mypage mypage = new Mypage();
            // view 객체에 이벤트의 Value 를 set 함
            mypage.setId(orderPlaced.getId());
            mypage.setOrderId(orderPlaced.getOrderId());
            mypage.setProductId(orderPlaced.getProductId());
            mypage.setProductName(orderPlaced.getProductName());
            mypage.setQty(orderPlaced.getQty());
            // view 레파지 토리에 save
            mypageRepository.save(mypage);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_UPDATE_1(@Payload OrderPlaced orderPlaced) {
        try {
            if (!orderPlaced.validate()) return;
                // view 객체 조회

                List<Mypage> mypageList = mypageRepository.findByOrderId(orderPlaced.getOrderId());
                for(Mypage mypage : mypageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    mypage.setStatus(orderPlaced.getStatus());
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryCompleted_then_UPDATE_2(@Payload DeliveryCompleted deliveryCompleted) {
        try {
            if (!deliveryCompleted.validate()) return;
                // view 객체 조회

                List<Mypage> mypageList = mypageRepository.findByOrderId(deliveryCompleted.getOderid());
                for(Mypage mypage : mypageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    mypage.setStatus(deliveryCompleted.getStatus());
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_UPDATE_3(@Payload OrderCanceled orderCanceled) {
        try {
            if (!orderCanceled.validate()) return;
                // view 객체 조회

                List<Mypage> mypageList = mypageRepository.findByOrderId(orderCanceled.getOrderId());
                for(Mypage mypage : mypageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    mypage.setStatus(orderCanceled.getStatus());
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryReturned_then_DELETE_1(@Payload DeliveryReturned deliveryReturned) {
        try {
            if (!deliveryReturned.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            mypageRepository.deleteByStatus(deliveryReturned.getStatus());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

