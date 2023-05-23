import axios from "axios";
const employee_base_url = "http://localhost:8080/employee";

class EmployeeService {
  getEmployees() {
    return axios.get(employee_base_url);
  }

  deleteEmployee(id: number) {
    return axios.delete(`${employee_base_url}/${id}`);
  }
}
export default new EmployeeService();
