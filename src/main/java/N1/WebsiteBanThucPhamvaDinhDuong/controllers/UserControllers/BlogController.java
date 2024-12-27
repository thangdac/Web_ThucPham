package N1.WebsiteBanThucPhamvaDinhDuong.controllers.UserControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @GetMapping
    public String blog() {
        return "user/blog/list";
    }
}
