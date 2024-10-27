package com.yhd.crud_empleado.service;

import com.yhd.crud_empleado.model.Empleado;
import com.yhd.crud_empleado.repo.EmpleadoRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class EmpleadoServiceTest {

    @Mock
    private EmpleadoRepository empleadoRepository;

    @InjectMocks
    private EmpleadoService empleadoService;


    @Test
    void findAllEmpleados() {
        Empleado empleado = new Empleado("Tom","Cat", LocalDate.of(2024,10,12),
                LocalDate.of(2004,10,12), "Here");
        Empleado empleado1 = new Empleado("Jerry","Mouse", LocalDate.of(2024,10,12),
                LocalDate.of(2014,1,2), "There");

        List<Empleado> empleadoList = Arrays.asList(empleado,empleado1);

        //Simulamos el comportamiento del repositorio para que devuelva el empleado creado
        Mockito.when(empleadoRepository.findAll()).thenReturn(empleadoList);

        List<Empleado> allEmpleados = empleadoService.findAllEmpleados();

        assertEquals(2, allEmpleados.size());
        assertEquals("Tom", allEmpleados.get(0).getName());
    }

    @Test
    void addEmpleado() {
        Empleado empleado = new Empleado("Tom","Cat", LocalDate.of(2024,10,12),
                LocalDate.of(2004,10,12), "Here");
        empleado.setId(1);
        //Simulamos el comportamiento del repositorio para que devuelva el empleado creado
        Mockito.when(empleadoRepository.save(Mockito.any(Empleado.class))).thenReturn(empleado);

        //se llama al metodo del servicio
        Empleado resultado = empleadoService.addEmpleado(empleado);

        // Verificamos que el resultado no sea nulo y tenga los datos esperados
        assertNotNull(resultado);
        assertEquals("Tom", resultado.getName());
        assertEquals("Cat", resultado.getLastName());

    }

    @Test
    void updateEmpleado() {
        Empleado empleado = new Empleado("Tom","Cat", LocalDate.of(2024,10,12),
                LocalDate.of(2004,10,12), "Here");
        empleado.setId(1);
        // Configuramos el mock para que al buscar el empleado por ID, devuelva el empleado existente
        Mockito.when(empleadoRepository.findById(1)).thenReturn(Optional.of(empleado));

        // Configuramos el mock para que al guardar, devuelva el empleado con los datos actualizados
        Mockito.when(empleadoRepository.save(empleado)).thenReturn(empleado);
        empleadoService.updateEmpleado(empleado);
        assertTrue(true);
    }

    @Test
    void deleteEmpleado() {
        Empleado empleado = new Empleado("Tom","Cat", LocalDate.of(2024,10,12),
                LocalDate.of(2004,10,12), "Here");
        empleado.setId(1);

        Mockito.when(empleadoRepository.findById(1)).thenReturn(Optional.of(empleado));

        empleadoService.deleteEmpleado(1);

        Mockito.verify(empleadoRepository, Mockito.times(1)).delete(empleado);
    }
}