package me.kozyar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {
        final String user = "postgres";
        final String password = "kOZYARIK82";
        final String url = "jdbc:postgresql://localhost:5432/skypro";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = connection.prepareStatement("SELECT*FROM employee WHERE id = (?)");
            statement.setInt(1, 3);
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String firstName = " first name: " + resultSet.getString("first_name");
                String lastName = " last name: " + resultSet.getString("last_name");
                String gender = " gender: " + resultSet.getString("gender");
                int age = resultSet.getInt("age");
                String city = " city: " + resultSet.getString("city_id");
                System.out.println(firstName + lastName + gender + " age: " + age + city);
            }
        }
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);
            City city = new City(1, "Tel-Aviv");
            Employee employee1 = new Employee(9, "Inna", "Rapaport", "female", 46, new City(2, "Tel-Aviv"));
            employeeDAO.create(employee1);
            System.out.println(employee1);
            employeeDAO.readById(9);
            List<Employee> list = new ArrayList<>(employeeDAO.readAll());
            for (Employee employee : list) {
                System.out.println(employee);
            }
        }
    }
}
