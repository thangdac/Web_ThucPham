package N1.WebsiteBanThucPhamvaDinhDuong.repositories;


import N1.WebsiteBanThucPhamvaDinhDuong.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    List<CartItem> findByCartCartId(Long cartId);

}
