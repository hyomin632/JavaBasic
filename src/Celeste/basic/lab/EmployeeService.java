package Celeste.basic.lab;

import Celeste.basic.grade.GradeVO;

public interface EmployeeService {
    void displayMenu();
    void newEmployee();
    void showEmployee();
    void showOneEmployee();
    void modifyEmployee();
    void removeEmployee();
    void makeExtInfo(EmployeeVO emp);

}

