package com.api.dock.service.interfaceService;

import com.api.dock.model.UserDock;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {
    List<UserDock> listar();

    Optional<UserDock> buscarPorId(long id);

    UserDock incluir(UserDock entity);

}
