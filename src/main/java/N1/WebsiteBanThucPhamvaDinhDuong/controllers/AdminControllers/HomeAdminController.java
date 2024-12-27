package N1.WebsiteBanThucPhamvaDinhDuong.controllers.AdminControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin-home")
public class HomeAdminController {
    @GetMapping
    public String home() {
        return "admin/home/index";
    }
}
