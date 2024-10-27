package com.yhd.crud_empleado.controller;

import com.yhd.crud_empleado.model.Empleado;
import com.yhd.crud_empleado.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("empleados")
public class EmpleadoController {
    private final EmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping("/todos")
    public List<Empleado> getAllEmpleados(){
        return empleadoService.findAllEmpleados();
    }

    @RequestMapping(path = "/add_empleado", method = RequestMethod.POST)
    public ResponseEntity<Empleado> addEmpleado(@RequestBody Empleado empleado){
        Empleado empleado1 = empleadoService.addEmpleado(empleado);
        return new ResponseEntity<>(empleado1, HttpStatus.CREATED);
    }

    @PutMapping(path = "update_empleado/{id}")
    public ResponseEntity<Empleado> updateEmpleado(@PathVariable Integer id, @RequestBody Empleado empAux
//                               @RequestParam(required = false) String name,
//                               @RequestParam(required = false) String lastName,
//                               @RequestParam(required = false) LocalDate startingDate,
//                               @RequestParam(required = false) LocalDate dob,
//                               @RequestParam(required = false) String address
                               ){
        Empleado empleado = empleadoService.updateEmpleado(empAux
                //  name, lastName, startingDate, dob, address
        );
        return ResponseEntity.ok(empleado);
    }

    @DeleteMapping(path = "delete_empleado/{id}")
    public void deleteEmpleado(@PathVariable Integer id){
        empleadoService.deleteEmpleado(id);

    }
}
