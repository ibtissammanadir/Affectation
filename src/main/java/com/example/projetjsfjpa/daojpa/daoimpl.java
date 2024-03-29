package com.example.projetjsfjpa.daojpa;

import com.example.projetjsfjpa.Model.Employee;
import com.example.projetjsfjpa.Model.Projet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;


public class daoimpl implements dao {
    private Long selectedEmployeId;
    private Long selectedProjetId;
    private List<Employee> employes;
    private List<Projet> projets;
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Employee");
    public List<Employee> employees;

    @Override
    public List<Employee> Lister(){
        String jpql = "SELECT e FROM Employee e";
        EntityManager em = emf.createEntityManager();
        this.employees = em.createQuery(jpql, Employee.class).getResultList();
        System.out.println("lister est bien");
        return employees;
    }
    @Override
    public List<Employee> ListerE(){
        String jpql = "SELECT e FROM Projet e";
        EntityManager em = emf.createEntityManager();
        this.employees = em.createQuery(jpql, Employee
                .class).getResultList();
        System.out.println("lister est bien");
        return employees;
    }
    public void affecterEmployeAuProjet() {
        EntityManager em = emf.createEntityManager();
        Employee employe = em.find(Employee.class, selectedEmployeId);
        Projet projet = em.find(Projet.class, selectedProjetId);
        employe.setProjet(projet);

        em.getTransaction().begin();
        em.merge(employe);
        em.getTransaction().commit();
    }
    @Override
    public void saveUser(Employee employee) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            if (employee.getId()== 0) {
                em.persist(employee);
            } else {
                em.merge(employee);
            }
            em.getTransaction().commit();
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }
    @Override
    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Employee employee = em.find(Employee.class, id);
            if (employee != null) {
                em.remove(employee);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

}
