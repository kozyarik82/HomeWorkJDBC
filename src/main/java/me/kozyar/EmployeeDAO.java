package me.kozyar;

import java.util.List;

public interface EmployeeDAO {

    // добавление объекта
    void create(Employee employee);

    // получение объекта по id
    Employee readById(int id);

    // получение списка всех объектов
    List<Employee> readAll();

    // изменение объекта
    void updateEmployee(Employee employee);

    // удаление оюъекта
    void delete(Employee employee);

}
