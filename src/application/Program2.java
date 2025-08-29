package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        List<Department> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== TEST 1: findById department ===");
        Department department = departmentDao.findById(8);
        System.out.println(department);

        System.out.println("=== TEST 2: findAll department ===");
        list = departmentDao.findAll();
        for (Department obj : list) {
            System.out.println(obj);
        }

        System.out.println("=== TEST 3: insert department");
        Department newDepartment = new Department(null, "D1");
        departmentDao.insert(newDepartment);
        System.out.println("Department inserted! New id = " + newDepartment.getId());

        System.out.println("=== TEST 4: update department ===");
        department = departmentDao.findById(11);
        department.setName("Kitchen");
        departmentDao.update(department);
        System.out.println("Update completed!");

        System.out.println("\n=== TEST 5: delete department ===");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");
    }
}
