package com.api.dock.service.interfaceService;

import com.api.dock.model.Person;
import com.api.dock.model.enums.StatusEnum;

import java.util.List;
import java.util.Optional;

public interface PersonServiceInterface {
        List<Person> listar();

        Optional<Person> buscarPorId(long id);

        Person incluir(Person entity);

        Person alterar(Person entity);

        List<Person> buscarPersonStatus(Integer statusEnum);

        void delete(Person entity);

        Person alterarSolicitacao(Person entity);
}
