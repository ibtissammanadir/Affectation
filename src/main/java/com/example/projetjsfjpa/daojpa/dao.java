package com.example.projetjsfjpa.daojpa;

import com.example.projetjsfjpa.Model.Employee;

import java.util.List;

public interface dao {
    List<Employee> Lister();
    void affecterEmployeAuProjet();
    void saveUser(Employee employee);
    void delete(int id);
    List<Employee> ListerE();
}
