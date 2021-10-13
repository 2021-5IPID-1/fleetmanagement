package be.ifosup.boilerplate.web.admin;

import be.ifosup.boilerplate.dto.UserDTO;
import be.ifosup.boilerplate.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

public class AbstractAdminController {

    @Autowired
    private UserService userService;

    public void addUserInModel(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        System.out.println(name);
        UserDTO user = userService.getUserByUserName(name);

        model.addAttribute("user", user);
    }
}
