package N1.WebsiteBanThucPhamvaDinhDuong.repositories;

import N1.WebsiteBanThucPhamvaDinhDuong.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findByOrderOrderId(Long orderId);

}

