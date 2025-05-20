package _dr21.contro_usuarios.services.impl;

import _dr21.contro_usuarios.entities.Role;
import _dr21.contro_usuarios.entities.User;
import _dr21.contro_usuarios.models.UserModel;
import _dr21.contro_usuarios.repositories.RoleRepository;
import _dr21.contro_usuarios.repositories.UserRepository;
import _dr21.contro_usuarios.services.UserService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
   // private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository= roleRepository;
       // this.passwordEncoder= passwordEncoder;

    }

    @Override
    public UserModel createUser(UserModel userModel) {

        System.out.println("username " + userModel.getUsername());
        System.out.println("user " + userModel.getName());
        System.out.println("role " + userModel.getRole());
        Optional<Role>  getRole= roleRepository.findByName(userModel.getRole());
        Set<Role> roles= new HashSet<>();
        roles.add(getRole.get());

        User user= new User();

        user.setName(userModel.getName());
        user.setUsername(userModel.getUsername());
        user.setPassword(userModel.getPassword());
        user.setRoles(roles);

        userRepository.save(user);

  if(user.getId()!=null){

      UserModel userResponse= new UserModel();
      userResponse.setId(user.getId());
      userResponse.setName(user.getName());
      userResponse.setUsername(user.getUsername());
      System.err.println("dentro de if llenado de response ....");
 return userResponse;
  }
    return null;
    }
}
