package com.yhd.crud_empleado.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Empleado {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY

    )
    private Integer id;
    private String name;
    private String lastName;
    private LocalDate startingDate;
    private LocalDate dob;
    private String address;

    public Empleado() {

    }

    public Empleado(String name, String lastName, LocalDate startingDate, LocalDate dob, String address) {
        this.name = name;
        this.lastName = lastName;
        this.startingDate = startingDate;
        this.dob = dob;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        if(this == obj)
            return true;
        Empleado empleado = (Empleado) obj;
        return this.getId().equals(empleado.getId()) && this.getName().equals(empleado.getName());
    }
}
