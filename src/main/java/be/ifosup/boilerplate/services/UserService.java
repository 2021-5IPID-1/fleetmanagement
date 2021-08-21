package be.ifosup.boilerplate.services;

import be.ifosup.boilerplate.config.common.datatables.DataTable;
import be.ifosup.boilerplate.dto.UserDTO;
import be.ifosup.boilerplate.form.CreateUserForm;

import java.util.List;

public interface UserService {
    List<UserDTO> getUsers();
    DataTable<UserDTO> getUsersDataTable(int draw, int start, int length);
    UserDTO create(CreateUserForm createUserForm);
}
