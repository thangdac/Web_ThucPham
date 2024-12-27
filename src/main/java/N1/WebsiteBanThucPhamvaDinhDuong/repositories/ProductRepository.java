package N1.WebsiteBanThucPhamvaDinhDuong.repositories;

import N1.WebsiteBanThucPhamvaDinhDuong.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByProductName(String productName);

}

