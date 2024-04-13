package co.edu.escuelaing.cvds.lab7.service;

import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(String id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee createEmployee(Employee employeeData) {
        return employeeRepository.save(employeeData);
    }

    public Employee updateEmployee(String id, Employee employeeData) {
        if (employeeRepository.existsById(id)) {
            int employeeId = Integer.parseInt(id);
            employeeData.setEmployeeId(employeeId);
            return employeeRepository.save(employeeData);
        }
        return null;
    }
    public boolean deleteEmployee(String id) {
        if (id != null && !id.isEmpty()) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public List<Employee> getEmployeesByPartialName(String partialName) {
        return employeeRepository.getByPartialName("%" + partialName + "%");
    }
}
