package com.rifa.repositories;

import com.rifa.model.Rifa;
import com.rifa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RifaRepository extends JpaRepository<Rifa, Long> {
    List<Rifa> findByUsuario (User user);

}
