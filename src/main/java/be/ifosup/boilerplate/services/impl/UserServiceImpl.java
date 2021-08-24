package be.ifosup.boilerplate.services.impl;

import be.ifosup.boilerplate.config.common.datatables.DataTable;
import be.ifosup.boilerplate.config.common.datatables.DataTableBackToFrontConverter;
import be.ifosup.boilerplate.constants.RoleEnum;
import be.ifosup.boilerplate.converter.backToFrontConverter.UserEntityToUserDTOConverter;
import be.ifosup.boilerplate.dto.UserDTO;
import be.ifosup.boilerplate.entities.User;
import be.ifosup.boilerplate.form.CreateUserForm;
import be.ifosup.boilerplate.form.UpdateUserForm;
import be.ifosup.boilerplate.repositories.UserRepository;
import be.ifosup.boilerplate.services.UserService;
import be.ifosup.boilerplate.utils.BCryptManagerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;
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
    public UserDTO get(Long id) {
        return userEntityToUserDTOConverter.convert(Objects.requireNonNull(userRepository.findById(id).orElse(null)));
    }

    @Override
    public DataTable<UserDTO> getUsersDataTable(int draw, int start, int length) {
        int page = start / length;
        Pageable pageable = PageRequest.of(page, length, Sort.Direction.DESC, "username");
        Page<User> all = userRepository.findAll(pageable);
        return dataTableBackToFrontConverter.convert(all, draw, start);
    }

    @Override
    public UserDTO create(CreateUserForm createUserForm) {
        Collection<RoleEnum> roleEnums = new ArrayList<>();
        roleEnums.add(RoleEnum.ADMIN);
        User user = User.builder()
                .username(createUserForm.getUsername())
                .emailaddress(createUserForm.getEmailaddress())
                .firstname(createUserForm.getFirstname())
                .lastname(createUserForm.getLastname())
                .password(BCryptManagerUtil.passwordEncoder().encode(createUserForm.getPassword()))
                .accountNonExpired(true)
                .accountNonLocked(true)
                .enabled(true)
                .credentialsNonExpired(true)
                .roles(roleEnums)
                .build();

        User userEntity = userRepository.save(user);

        return userEntityToUserDTOConverter.convert(userEntity);
    }

    @Override
    public UserDTO update(UpdateUserForm updateUserForm) {
        User userInit = userRepository.getOne(updateUserForm.getId());
        User user = User.builder()
                .username(userInit.getUsername())
                .emailaddress(userInit.getEmailaddress())
                .firstname(updateUserForm.getFirstname())
                .lastname(updateUserForm.getLastname())
                .password(userInit.getPassword())
                .accountNonExpired(true)
                .accountNonLocked(true)
                .enabled(true)
                .credentialsNonExpired(true)
                .roles(userInit.getRoles())
                .id(updateUserForm.getId())
                .build();

        User userEntity = userRepository.save(user);

        return userEntityToUserDTOConverter.convert(userEntity);
    }
}
