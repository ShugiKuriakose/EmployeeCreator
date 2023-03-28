import { useEffect, useState } from "react";
import "./App.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import EmployeeListLoader from "./containers/EmployeeListLoader";
import CreateEmployeeForm from "./components/CreateEmployeeForm";
import Employee from "./components/Employee";
import { getAllEmployees } from "./services/employee-services";

function App() {
  const [employees, setEmployees] = useState([]);
  useEffect(() => {
    getAllEmployees().then(setEmployees);
  }, []);

  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<p>Hello world</p>} />
          <Route path="/employees" element={<EmployeeListLoader />} />
          <Route path="/employees/new" element={<CreateEmployeeForm />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
