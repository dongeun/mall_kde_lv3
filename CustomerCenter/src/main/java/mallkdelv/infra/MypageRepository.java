package mallkdelv.infra;

import mallkdelv.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel="mypages", path="mypages")
public interface MypageRepository extends PagingAndSortingRepository<Mypage, Long> {

    List<Mypage> findByOrderId(Long orderId);


    void deleteByStatus(String status);

}
