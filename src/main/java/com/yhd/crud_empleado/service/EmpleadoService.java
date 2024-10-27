package com.yhd.crud_empleado.service;

import com.yhd.crud_empleado.model.Empleado;
import com.yhd.crud_empleado.repo.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {
    private final EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public List<Empleado> findAllEmpleados() {
        return empleadoRepository.findAll();
    }

//    public void addEmpleado(Empleado empleado) {
//        Optional<Empleado> byId = empleadoRepository
//                .findByNameAndLastName(empleado.getName(),empleado.getLastName());
//        if(byId.isEmpty()){
//            empleadoRepository.save(empleado);
//        }else throw new IllegalStateException("Ya existe empleado con ese nombre y apellido");
//    }

    public Empleado addEmpleado(Empleado empleado) {
        Optional<Empleado> byId = empleadoRepository
                .findByNameAndLastName(empleado.getName(),empleado.getLastName());
        if(byId.isEmpty()){
            return empleadoRepository.save(empleado);
        }else throw new IllegalStateException("Ya existe empleado con ese nombre y apellido");
    }
    @Transactional
    public Empleado updateEmpleado(Empleado emp) {
        Empleado empleado = empleadoRepository.findById(emp.getId()).orElseThrow(() -> new IllegalStateException("Doesnt" +
                "exist"));
        if(emp.getName() != null && !empleado.getName().equals(emp.getName()))
            empleado.setName(emp.getName());
        if(emp.getLastName() != null && !empleado.getLastName().equals(emp.getLastName()))
            empleado.setLastName(emp.getLastName());
        if(emp.getStartingDate() != null)
                 empleado.setStartingDate(emp.getStartingDate());
        if(emp.getDob() != null)
            empleado.setDob(emp.getDob());
        if(emp.getAddress() != null && !emp.getAddress().isEmpty())
            empleado.setAddress(emp.getAddress());
        return empleadoRepository.save(empleado);
    }


    public void deleteEmpleado(Integer id) {
        Empleado empleado = empleadoRepository.findById(id).orElseThrow(() -> new IllegalStateException(""));
        empleadoRepository.delete(empleado);


    }
}
