import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import EmployeeService from "../../services/EmployeeService";
import { RouteProps } from "react-router-dom";
import { Employee } from "../../interface/EmployeeInterface";
import styles from "./EmployeeList.module.scss";

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
      <h2 className={styles.heading}>EMPLOYEE MANAGEMENT SYSTEM</h2>

      <div className={styles.Click}>
        <Link to="/add-employee" className={styles.addEmployee}>
          ADD EMPLOYEE
        </Link>
      </div>

      <div className="row">
        <table>
          <thead>
            <tr>
              <th>FIRST NAME</th>
              <th>MIDDLE NAME</th>
              <th>LAST NAME</th>
              <th>EMAIL</th>
              <th>ACTION</th>
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
