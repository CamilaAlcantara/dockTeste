package com.api.dock.repository;

import com.api.dock.model.Person;
import com.api.dock.model.enums.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository <Person,Long>{

    @Query(value="SELECT * FROM PERSON WHERE ID = ?1 ",nativeQuery = true)
    public Person verificaId(long id);

    @Query(value="SELECT * FROM PERSON WHERE DOCUMENT LIKE ?1 ",nativeQuery = true)
    public Person buscarPersonPorDocument(String username);

    @Query(value="SELECT * FROM PERSON WHERE STATUS = ?1 ",nativeQuery = true)
    public List<Person> buscarPersonStatus(Integer statusEnum);


//        SELECT tb.id, tb.name, tb.lastname, tb.document, to_char( tb.date_request, 'DD-mm-YYYY') as date_equest, to_char( tb.update_status_request, 'DD-mm-YYYY') as update_status_request, tb.phone, tb.address, tb.status from person tb where status = 0
}
