package com.api.dock.service;

import com.api.dock.model.UserDock;
import com.api.dock.repository.UserRepository;
import com.api.dock.service.interfaceService.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    UserRepository userRepository;


    @Override
    public List<UserDock> listar(){

        return userRepository.findAll();
    }

    @Override
    public Optional<UserDock> buscarPorId(long id){
        return this.userRepository.findById(id);
    }

    @Override
    public UserDock incluir(UserDock entity) {

       UserDock userDockValido = userRepository.buscarPersonPorUsername(entity.getUsername());

        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        if(userDockValido != null) {
            return null;
        }else {
            entity.setPassword(passwordEncoder.encode(entity.getPassword()));
            return this.userRepository.save(entity);

        }
    }

}
