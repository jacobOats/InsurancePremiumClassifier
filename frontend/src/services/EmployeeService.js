// services/EmployeeService.js
import axios from 'axios';
class EmployeeService {
  constructor() {
    this.employees = [];
  }

  addEmployee(firstName,lastName,manager,organizaiton) {
    const newEmployee = new Employee(firstName,lastName,manager,organizaiton);
    this.employees.push(newEmployee);
    return newEmployee;
  }

  getEmployeesById(id) {
    return this.employees.find(employees => employees.id === id);
  }

  getAllEmployees() {
    return axios.get('http://localhost:8080/api/employees/emp')
        .then(response => response.data)
        .catch(error => {
            console.error('Error fetching Employees:', error);
            throw error; // Propagate error to caller
        });
}
}

export default EmployeeService;
