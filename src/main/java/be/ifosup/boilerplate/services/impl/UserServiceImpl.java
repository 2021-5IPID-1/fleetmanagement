package be.ifosup.boilerplate.services.impl;

import be.ifosup.boilerplate.config.common.datatables.DataTable;
import be.ifosup.boilerplate.config.common.datatables.DataTableBackToFrontConverter;
import be.ifosup.boilerplate.converter.backToFrontConverter.UserEntityToUserDTOConverter;
import be.ifosup.boilerplate.dto.UserDTO;
import be.ifosup.boilerplate.entities.User;
import be.ifosup.boilerplate.repositories.UserRepository;
import be.ifosup.boilerplate.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserEntityToUserDTOConverter userEntityToUserDTOConverter;
    private DataTableBackToFrontConverter<UserDTO> dataTableBackToFrontConverter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           UserEntityToUserDTOConverter userEntityToUserDTOConverter,
                           DataTableBackToFrontConverter<UserDTO> dataTableBackToFrontConverter) {
        this.userRepository = userRepository;
        this.userEntityToUserDTOConverter = userEntityToUserDTOConverter;
        this.dataTableBackToFrontConverter = dataTableBackToFrontConverter;
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> userList = userRepository.findAll();
        List<UserDTO> userDTOList = userList.stream().map(user -> userEntityToUserDTOConverter.convert(user)).collect(Collectors.toList());
        return userDTOList;
    }

    @Override
    public DataTable<UserDTO> getUsersDataTable(int draw, int start, int length) {
        int page = start / length;
        Pageable pageable = PageRequest.of(page, length, Sort.Direction.DESC, "username");
        Page<User> all = userRepository.findAll(pageable);
        return dataTableBackToFrontConverter.convert(all, draw, start);
    }
}
