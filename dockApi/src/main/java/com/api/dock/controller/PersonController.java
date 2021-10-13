package com.api.dock.controller;


import com.api.dock.model.Person;
import com.api.dock.model.enums.StatusEnum;
import com.api.dock.service.interfaceService.PersonServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value="/personProposal")
public class PersonController {

    @Autowired
    PersonServiceInterface personServiceInterface;

    @GetMapping("/listar")
    @PreAuthorize("hasRole('USER')")
    public List<Person> listar() {
        return personServiceInterface.listar();
    }

    @GetMapping("/buscarPorId/{id}")
    @PreAuthorize("hasRole('USER')")
    public Optional<Person> buscarPorId(@PathVariable("id") long id) {
        return personServiceInterface.buscarPorId(id);

    }

    @PostMapping("/incluir")
    @PreAuthorize("hasRole('REQUEST')")
    public Person incluir(@RequestBody Person entity) {
        return personServiceInterface.incluir(entity);
    }

    @PutMapping("/alterarSolicitacao")
    @PreAuthorize("hasRole('REQUEST')")
    public Person alterarSolicitacao(@RequestBody Person entity){
        return personServiceInterface.alterarSolicitacao(entity);
    }

    @PutMapping("/alterar")
    @PreAuthorize("hasRole('APPROVER')")
    public Person alterar(@RequestBody Person entity){
        return personServiceInterface.alterar(entity);
    }

    @GetMapping("/buscarPorStatus/{statusEnum}")
    @PreAuthorize("hasRole('USER')")
    public List<Person> buscarPorStatus(@PathVariable("statusEnum")Integer statusEnum) {
        return personServiceInterface.buscarPersonStatus(statusEnum);
    }


    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@RequestBody Person entity){
        personServiceInterface.delete(entity);
    }
}
