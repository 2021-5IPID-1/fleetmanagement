package be.ifosup.boilerplate.web.admin;

import be.ifosup.boilerplate.dto.UserDTO;
import be.ifosup.boilerplate.form.CreateUserForm;
import be.ifosup.boilerplate.form.UpdateUserForm;
import be.ifosup.boilerplate.services.UserService;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
        return "admin/manage-users";
    }

    @GetMapping("/create-user-page")
    public String createUserPage(Model model) {
        model.addAttribute("user", new CreateUserForm());
        return "admin/user/create";
    }

    @GetMapping("/update-user-page/{id}")
    public String userFormPage(@PathVariable("id") String id, Model model) {
        UserDTO userDTO = userService.get(Long.valueOf(id));

        model.addAttribute("user", userDTO != null ? userDTO : new CreateUserForm());
        return "admin/user/update";
    }

    @PostMapping("/create-user")
    public String validateCreation(@Valid @ModelAttribute("user") CreateUserForm createUserForm, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "admin/user/create";
        }
        userService.create(createUserForm);
        return "redirect:/admin/manage-users";
    }

    @PostMapping("/update-user")
    public String validateUpdate(@Valid @ModelAttribute("user") UpdateUserForm updateUserForm, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "admin/user/update";
        }
        userService.update(updateUserForm);
        return "redirect:/admin/manage-users";
    }
}
