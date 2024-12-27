package N1.WebsiteBanThucPhamvaDinhDuong.repositories;

import N1.WebsiteBanThucPhamvaDinhDuong.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart findByUserUsername(String username);

}
