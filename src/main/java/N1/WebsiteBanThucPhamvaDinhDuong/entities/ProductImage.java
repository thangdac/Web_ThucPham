package N1.WebsiteBanThucPhamvaDinhDuong.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product_images")
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productImgId", nullable = false, updatable = false)
    private Long productImgId;

    @NotBlank(message = "Image URL is required")
    @Column(name = "imgsUrl", length = 255, nullable = false)
    private String imgsUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId", referencedColumnName = "productId", nullable = false)
    @ToString.Exclude
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductImage that = (ProductImage) o;
        return productImgId != null && Objects.equals(productImgId, that.productImgId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productImgId);
    }
}

