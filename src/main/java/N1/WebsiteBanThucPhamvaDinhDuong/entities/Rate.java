package N1.WebsiteBanThucPhamvaDinhDuong.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Rate")
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ratingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", nullable = false)
    private User user;

    @Column(nullable = false)
    private int rating; // Rating value (e.g., 1 to 5 stars)

    @Column(columnDefinition = "TEXT")
    private String review; // Optional review text

    @Column(nullable = false)
    private LocalDateTime ratingDate = LocalDateTime.now();

}

