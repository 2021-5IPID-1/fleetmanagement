package be.ifosup.boilerplate.web.admin;

import be.ifosup.boilerplate.form.CreateUserForm;
import be.ifosup.boilerplate.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class ManageUsersController {

    private UserService userService;

    @Autowired
    public ManageUsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/manage-users")
    public String manageUsersPage(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "admin/manage-users";
    }

    @GetMapping("/create-user-page")
    public String createUserPage() {
        return "admin/user/create";
    }

    @PostMapping("/create-user")
    public String validateCreation(@Valid CreateUserForm createUserForm) {
        userService.create(createUserForm);
        return "admin/manage-users";
    }
}
