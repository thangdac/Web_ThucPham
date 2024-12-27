package N1.WebsiteBanThucPhamvaDinhDuong.entities;

import N1.WebsiteBanThucPhamvaDinhDuong.repositories.ValidationGroups;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @Column(name = "username", length = 30, unique = true, nullable = false)
    @NotBlank(message = "Username is required", groups = ValidationGroups.OnCreate.class)
    @Size(min = 1, max = 30, message = "Username must be between 1 and 30 characters", groups = ValidationGroups.OnCreate.class)
    private String username;

    @Column(name = "password", length = 255, nullable = false)
    @NotBlank(message = "Password is required", groups = {ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class})
    private String password;

    @Transient
    @NotBlank(message = "Confirm Password is required", groups = ValidationGroups.OnCreate.class)
    private String confirmPassword;

    @Column(name = "email", length = 100, unique = true, nullable = false)
    @Email(message = "Email should be valid", groups = ValidationGroups.OnCreate.class)
    private String email;

    @Column(name = "phone", length = 10, nullable = false)
    @Length(min = 10, max = 10, message = "Phone must be 10 characters", groups = ValidationGroups.OnCreate.class)
    @Pattern(regexp = "^[0-9]*$", message = "Phone must be numeric", groups = ValidationGroups.OnCreate.class)
    private String phone;

    @Column(name = "fullname", length = 30)
    private String fullname;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "height")
    private Double height;

    @Column(name = "coupon", length = 10)
    private String coupon;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @ToString.Exclude
    private Cart cart;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Ensure Role has a valid getRoleName method
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                .toList();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return getUsername() != null && Objects.equals(getUsername(), user.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
