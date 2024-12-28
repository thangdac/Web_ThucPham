package N1.WebsiteBanThucPhamvaDinhDuong.repositories;

import N1.WebsiteBanThucPhamvaDinhDuong.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Có thể thêm các phương thức tùy chỉnh nếu cần
}