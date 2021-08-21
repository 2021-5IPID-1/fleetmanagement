package be.ifosup.boilerplate.ws.admin;

import be.ifosup.boilerplate.config.common.datatables.DataTable;
import be.ifosup.boilerplate.dto.UserDTO;
import be.ifosup.boilerplate.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/ws/admin/users")
public class UsersWSController {
    private final UserService userService;

    @Autowired
    public UsersWSController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity list(@RequestParam("draw") int draw, @RequestParam("start") int start, @RequestParam("length") int length) {
        DataTable<UserDTO> usersDataTable = userService.getUsersDataTable(draw, start, length);

        return ResponseEntity.ok(usersDataTable);
    }
}
