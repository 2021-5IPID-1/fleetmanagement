package be.ifosup.boilerplate.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Admin controller
 */
@Controller
@RequestMapping("/admin/test")
public class AdminController extends AbstractAdminController {

    @GetMapping
    public String adminPage(Model model) {
        addUserInModel(model);
        return "admin/index";
    }
}
