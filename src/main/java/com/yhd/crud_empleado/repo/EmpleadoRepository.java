package com.yhd.crud_empleado.repo;

import com.yhd.crud_empleado.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

    Optional<Empleado> findByNameAndLastName(String name, String lastName);
}
