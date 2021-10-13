package com.api.dock.controller;


import com.api.dock.model.UserDock;
import com.api.dock.service.interfaceService.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/user")
public class UserController  {

    @Autowired
    UserServiceInterface userServiceInterface;

    @GetMapping("/listar")
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserDock> listar() {
        return userServiceInterface.listar();
    }

    @GetMapping("/buscarPorId/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Optional<UserDock> buscarPorId(@PathVariable("id") long id) {
        return userServiceInterface.buscarPorId(id);
    }

    @PostMapping("/incluir")
    @PreAuthorize("hasRole('ADMIN')")
    public UserDock incluir(@RequestBody UserDock entity) {
        return	userServiceInterface.incluir(entity);
    }
}
