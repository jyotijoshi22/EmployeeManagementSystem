import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import EmployeeService from "../services/EmployeeService";
import { RouteProps } from "react-router-dom";
import { Employee } from "../interface/EmployeeInterface";

const EmployeeList: React.FC<RouteProps> = () => {
  const [employees, setEmployees] = useState<Employee[]>([]);

  useEffect(() => {
    EmployeeService.getEmployees().then(
      (res: { data: React.SetStateAction<Employee[]> }) => {
        setEmployees(res.data);
      }
    );
  }, []);

  const handleDelete = (id: any) => {
    EmployeeService.deleteEmployee(id).then(() => {
      setEmployees((prevEmployees) => prevEmployees.filter((e) => e.id !== id));
    });
  };

  return (
    <div>
      <h2 className="text-center">Employee's List</h2>

      <div className="row">
        <h3> Please click on Edit to find more details of each employee</h3>
        <Link to="/add-employee" className="btn btn-primary">
          ADD EMPLOYEE
        </Link>
      </div>

      <div className="row">
        <table className="table table-striped table-bordered">
          <thead>
            <tr>
              <th>First Name</th>
              <th>Middle Name</th>
              <th>Last Name</th>
              <th>Email</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {employees.map((employee, index) => (
              <tr key={employee.id}>
                <td>{employee.firstName}</td>
                <td>{employee.middleName}</td>
                <td>{employee.lastName}</td>
                <td>{employee.emailId}</td>
                <td>
                  <button>EDIT</button>
                  <button onClick={() => handleDelete(employee.id)}>
                    REMOVE
                  </button>
                  <button>DETAILS</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default EmployeeList;
