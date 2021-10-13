package com.api.dock.repository;

import com.api.dock.model.UserDock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository <UserDock,Long>{

    UserDock findByUsername(String username);

    @Query(value="SELECT * FROM USER_DOCK WHERE ID = ?1 ",nativeQuery = true)
    public UserDock verificaId(long id);

    @Query(value="SELECT * FROM USER_DOCK WHERE USERNAME LIKE ?1 ",nativeQuery = true)
    public UserDock buscarPersonPorUsername(String username);
}
