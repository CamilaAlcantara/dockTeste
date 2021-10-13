package com.api.dock.service;

import com.api.dock.model.Person;
import com.api.dock.model.enums.StatusEnum;
import com.api.dock.repository.PersonRepository;
import com.api.dock.service.interfaceService.PersonServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements PersonServiceInterface{

    @Autowired
    PersonRepository personRepository;


    @Override
    public List<Person> listar(){

        return personRepository.findAll();
    }

    @Override
    public Optional<Person> buscarPorId(long id){
        return this.personRepository.findById(id);
    }

    @Override
    public Person incluir(Person entity) {

        Person personPorUsernameDocument = personRepository.buscarPersonPorDocument(entity.getDocument());

        if(personPorUsernameDocument != null) {
            return null;
        }else {

            entity.setDateRequest(LocalDate.now());
            entity.setUpdateStatusRequest(LocalDate.now());
            entity.setStatus(StatusEnum.REVIEW);


           return this.personRepository.save(entity);

        }
    }

    @Override
    public Person alterarSolicitacao(Person entity) {
        //		verificando se o id existe
        Person personPorId = personRepository.verificaId(entity.getId());
        if(personPorId != null) {
            entity.setDateRequest(personPorId.getDateRequest());
            entity.setUpdateStatusRequest(LocalDate.now());
            entity.setStatus(StatusEnum.REVIEW);

            return this.personRepository.save(entity);
        }else {
            return this.incluir(entity);
        }
    }
    @Override
    public Person alterar(Person entity) {

//		verificando se o id existe
        Person personPorId = personRepository.verificaId(entity.getId());

        if(personPorId != null) {

            switch (entity.getStatus()){
                case APPROVED:
                    entity.setStatus(StatusEnum.APPROVED);
                    break;
                case DISAPPROVED:
                    entity.setStatus(StatusEnum.DISAPPROVED);
                    break;
                case REVIEW:
                    entity.setStatus(StatusEnum.REVIEW);
                    break;
            }
            entity.setDateRequest(personPorId.getDateRequest());
            entity.setUpdateStatusRequest(LocalDate.now());
            return this.personRepository.save(entity);
        }else {
            return this.incluir(entity);
        }
    }

    @Override
    public List<Person>  buscarPersonStatus(Integer statusEnum){
        return this.personRepository.buscarPersonStatus(statusEnum);
    }
    @Override
    public void delete(Person entity) {
        this.personRepository.delete(entity);
    }

}
