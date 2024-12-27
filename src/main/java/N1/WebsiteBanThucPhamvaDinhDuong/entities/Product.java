package N1.WebsiteBanThucPhamvaDinhDuong.entities;

import N1.WebsiteBanThucPhamvaDinhDuong.repositories.ValidationGroups;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId", nullable = false, updatable = false)
    private Long productId;

    @NotBlank(message = "Product name is required", groups = ValidationGroups.OnCreate.class)
    @Size(max = 255, message = "Product name must be less than 255 characters", groups = {ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class})
    @Column(name = "productName", length = 255, nullable = false)
    private String productName;

    @NotBlank(message = "Origin is required", groups = ValidationGroups.OnCreate.class)
    @Size(max = 30, message = "Origin must be less than 30 characters", groups = {ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class})
    @Column(name = "origin", length = 30, nullable = false)
    private String origin;

    @NotNull(message = "Price is required", groups = ValidationGroups.OnCreate.class)
    @Min(value = 1, message = "Price must be greater than 0", groups = {ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class})
    @Column(name = "price", nullable = false)
    private Long price;

    @Min(value = 0, message = "Quantity must be 0 or more", groups = {ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class})
    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "imgUrl", length = 255)
    private String imgUrl;

    @Min(value = 0, message = "Calories must be 0 or more", groups = {ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class})
    @Column(name = "calo")
    private Double calo;

    @Min(value = 0, message = "Water content must be 0 or more", groups = {ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class})
    @Column(name = "water")
    private Double water;

    @Min(value = 0, message = "Carbs must be 0 or more", groups = {ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class})
    @Column(name = "carb")
    private Double carb;

    @Min(value = 0, message = "Protein must be 0 or more", groups = {ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class})
    @Column(name = "protein")
    private Double protein;

    @Min(value = 0, message = "Fat must be 0 or more", groups = {ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class})
    @Column(name = "fat")
    private Double fat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId", nullable = false)
    @ToString.Exclude
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<CartItem> cartItems = new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<OrderItem> orderItems = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;
        return productId != null && Objects.equals(productId, product.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
}

