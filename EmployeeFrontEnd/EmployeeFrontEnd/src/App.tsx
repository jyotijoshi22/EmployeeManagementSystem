import { useState } from "react";
import reactLogo from "./assets/react.svg";
import "./App.css";
import CreateEmployee from "./components/CreateEmployee/CreateEmployee";
import EmployeeList from "./components/EmployeeList/EmployeeList";
import { BrowserRouter, Routes, Route } from "react-router-dom";

function App() {
  const [count, setCount] = useState(0);

  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/employee" element={<EmployeeList />} />
          <Route path="/add-employee" element={<CreateEmployee />}></Route>
          {/* <Route path="/employee/:id" element={<EmployeePage />}></Route> */}
          {/* <Route path="table" element={<Table employees={employees} />}></Route> */}
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
