import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { createEmployee } from "../services/employee-services";

const CreateEmployeeForm = () => {
  const initialFormValues = {
    name: "",
    employmentType: "",
    email: "",
    yearsEmployed: 0,
  };
  const [formValues, setFormValues] = useState(initialFormValues);

  const navigate = useNavigate();

  const onChange = (event) => {
    const { value, id } = event.target;
    setFormValues({ ...formValues, [id]: value });
  };

  const onFormSubmit = (event) => {
    event.preventDefault();
    createEmployee(formValues)
      .then(() => navigate("/employees"))
      .catch((error) => console.log(error));
  };

  return (
    <div>
      <h1>Create new Employee</h1>
      <form onSubmit={onFormSubmit}>
        <div className="field">
          <label>Name</label>
          <input
            type="text"
            id="name"
            value={formValues.name}
            onChange={onChange}
          />
        </div>

        <div className="field">
          <label>Employment Type</label>
          <select
            id="employmentType"
            value={formValues.employmentType}
            onChange={onChange}
          >
            <option value="Permanent">Permanent</option>
            <option value="Contract">Contract</option>
          </select>
        </div>
        <div className="field">
          <label>Email</label>
          <input
            type="text"
            id="email"
            value={formValues.email}
            onChange={onChange}
          />
        </div>
        <div className="field">
          <label>Years Employed</label>
          <input
            type="number"
            id="yearsEmployed"
            value={formValues.yearsEmployed}
            onChange={onChange}
          />
        </div>
        <div className="field">
          <button type="submit">Create Employee</button>
        </div>
      </form>
    </div>
  );
};

export default CreateEmployeeForm;
