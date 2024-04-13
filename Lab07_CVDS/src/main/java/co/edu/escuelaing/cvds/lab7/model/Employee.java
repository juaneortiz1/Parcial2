package co.edu.escuelaing.cvds.lab7.model;

import jakarta.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
@NamedQuery(name = "Employee.getByPartialName",
        query = "SELECT e FROM Employee e WHERE e.firstName LIKE :partialName OR e.lastName LIKE :partialName")
public class Employee {
    @Id
    @Column(name = "EMPLOYEE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId; // Cambiado a int

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "ROLE")
    private String role;

    @Column(name = "SALARY")
    private Double salary;

    public Employee() {
    }

    public Employee(int employeeId, String firstName, String lastName, String role, Double salary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName +
                ", role=" + role + ", salary=" + salary + "]";
    }
}
