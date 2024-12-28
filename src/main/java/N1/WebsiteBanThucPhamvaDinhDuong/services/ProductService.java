package N1.WebsiteBanThucPhamvaDinhDuong.services;

import N1.WebsiteBanThucPhamvaDinhDuong.entities.Product;
import N1.WebsiteBanThucPhamvaDinhDuong.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


}
