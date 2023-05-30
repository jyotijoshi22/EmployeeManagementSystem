import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { Employee } from "../../interface/EmployeeInterface";
import styles from "./CreateEmployee.module.scss";
import GoogleAutocomplete from "react-google-autocomplete";

import "react-datepicker/dist/react-datepicker.css";

const CreateEmployee = () => {
  const [employee, setNewEmployee] = useState<Employee>({
    id: "",
    firstName: "",
    middleName: "",
    lastName: "",
    emailId: "",
    contactNumber: "",
    address: "",
    contractType: "",
    startDate: "",
    finishDate: "",
    onGoing: "",
    workTimeType: "",
    hoursPerWeek: "",
  });
  const [startFinishDates, setStartFinishDates] = useState({
    startDateDay: "",
    startDateMonth: "",
    startDateYear: "",
    finishDateDay: "",
    finishDateMonth: "",
    finishDateYear: "",
  });
  const [ongoing, setOngoing] = useState("false");
  const [workingType, setWorkingType] = useState("");
  const handleContractTypeChange = (
    event: React.ChangeEvent<HTMLInputElement>
  ) => {
    setNewEmployee((prevEmployee) => ({
      ...prevEmployee,
      contractType: event.target.value,
    }));
  };

  let navigate = useNavigate();

  const handleDatesChange = (e: { target: { name: any; value: any } }) => {
    setStartFinishDates({
      ...startFinishDates,
      [e.target.name]: e.target.value,
    });
  };

  const handleChange = (e: { target: { name: any; value: any } }) => {
    const { name, value } = e.target;
    setNewEmployee((prevEmployee) => ({
      ...prevEmployee,
      [name]: value,
    }));
  };

  const handleSubmit = (e: { preventDefault: () => void }) => {
    e.preventDefault();

    // Including the ongoing value
    const payload = {
      ...employee,
      onGoing: ongoing,
      workTimeType: workingType,
    };
    axios
      .post("http://127.0.0.1:5173/employee/create", payload)
      .then(() => {
        navigate("/employee");
      })
      .catch((error) => {
        console.log("Error saving employee:", error);
      });
  };

  const handleAddressSelect = (address: any) => {
    console.log(address); // Do something with the selected address
  };

  return (
    <form className={styles.formContainer}>
      <h1 className={styles.sectionTitle}>PERSONAL INFORMATION</h1>
      <div className={styles.inputContainer}>
        <label htmlFor="firstName">First Name</label>
        <input
          id="firstName"
          type="text"
          name="firstName"
          pattern="[A-Za-z]{1,30}"
          required
          placeholder="John"
          onChange={handleChange}
          className={styles.firstNameInput}
        />
      </div>
      <div className={styles.inputContainer}>
        <label htmlFor="middleName">Middle Name(if applicable)</label>
        <input
          id="middleName"
          type="text"
          name="middleName"
          pattern="[A-Za-z]{1,30}"
          onChange={handleChange}
        />
      </div>
      <div className={styles.inputContainer}>
        <label htmlFor="lastName">Last Name</label>
        <input
          id="lastName"
          type="text"
          name="lastName"
          pattern="[A-Za-z]{1,30}"
          required
          placeholder="Smith"
          onChange={handleChange}
        />
      </div>

      <h2>CONTACT DETAILS</h2>
      <div>
        <div className={styles.inputContainer}>
          <label htmlFor="emailAddress">Email address</label>
          <input
            id="emailAddress"
            type="email"
            name="emailAddress"
            required
            placeholder="sam.riley@gmail.com"
            onChange={handleChange}
          />
        </div>
        <div className={styles.inputContainer}>
          <label htmlFor="mobileNum">
            Mobile number(Must be an Australian Number)
          </label>
          <input
            id="mobileNum"
            type="tel"
            name="mobileNum"
            pattern="[0-9]{10}"
            required
            placeholder="0412345678"
            onChange={handleChange}
          />
        </div>
        <div className={styles.inputContainer}>
          <label htmlFor="address">Residential Address</label>
          <GoogleAutocomplete
            id="address"
            type="text"
            name="address"
            onPlaceSelected={handleAddressSelect}
            required
            placeholder="123 Example St.Sydney NSW 2000"
          />
        </div>
      </div>

      <h2>EMPLOYEE STATUS</h2>
      <p>What is contract type?</p>
      <div>
        <label htmlFor="permanent">Permanent</label>
        <input
          id="permanent"
          type="radio"
          name="contractType"
          value="permanent"
          checked={employee.contractType === "permanent"}
          onChange={handleContractTypeChange}
        />
      </div>
      <div>
        <label htmlFor="Contract">Contract</label>
        <input
          id="permanent"
          type="radio"
          name="contractType"
          value="permanent"
          checked={employee.contractType === "contract"}
          onChange={handleContractTypeChange}
        />
      </div>

      <p> Start Date</p>
      <div className={styles.startDateContainer}>
        <div className={styles.startDateField}>
          <label htmlFor="startDateDay" placeholder="28">
            Day
          </label>
          <input
            id="startDateDay"
            type="number"
            name="startDateDay"
            value={startFinishDates.startDateDay}
            onChange={handleDatesChange}
            min={1}
            max={31}
            required
            placeholder="28"
          />
        </div>
        <div>
          <label>Month</label>
          <select
            name="startDateMonth"
            value={startFinishDates.startDateMonth}
            onChange={handleDatesChange}
          >
            <option value="01">Jan</option>
            <option value="02">Feb</option>
            <option value="03">March</option>
            <option value="04">April</option>
            <option value="05">May</option>
            <option value="06">June</option>
            <option value="07">July</option>
            <option value="08">Aug</option>
            <option value="09">Sept</option>
            <option value="10">Oct</option>
            <option value="11">Nov</option>
            <option value="12">Dec</option>
          </select>
        </div>
        <div>
          <label htmlFor="startDateYear">Year</label>
          <input
            id="startDateYear"
            type="number"
            name="startDateYear"
            required
            placeholder="2021"
            min={new Date().getFullYear() - 40}
            max={new Date().getFullYear()}
            value={startFinishDates.startDateYear}
            onChange={handleDatesChange}
          />
        </div>
      </div>
      <p> Finish Date</p>
      <div className={styles.startDateContainer}>
        <div className={styles.startDateField}>
          <label htmlFor="finishDateDay" placeholder="28">
            Day
          </label>
          <input
            id="finishDateDay"
            type="number"
            name="finishDateDay"
            min={1}
            max={31}
            required
            placeholder="28"
            value={startFinishDates.finishDateDay}
            onChange={handleDatesChange}
          />
        </div>
        <div>
          <label>Month</label>
          <select
            name="finishDateMonth"
            onChange={handleDatesChange}
            value={startFinishDates.finishDateMonth}
          >
            <option value="01">Jan</option>
            <option value="02">Feb</option>
            <option value="03">March</option>
            <option value="04">April</option>
            <option value="05">May</option>
            <option value="06">June</option>
            <option value="07">July</option>
            <option value="08">Aug</option>
            <option value="09">Sept</option>
            <option value="10">Oct</option>
            <option value="11">Nov</option>
            <option value="12">Dec</option>
          </select>
        </div>
        <div>
          <label htmlFor="finishDateYear">Year</label>
          <input
            id="finishDateYear"
            type="number"
            name="finishDateYear"
            required
            placeholder="2021"
            min={new Date().getFullYear() - 40}
            max={new Date().getFullYear()}
            onChange={handleDatesChange}
            value={startFinishDates.finishDateYear}
          />
        </div>
      </div>

      <div>
        <input
          id="onGoing"
          type="checkbox"
          checked={ongoing === "true"}
          onChange={(event) =>
            setOngoing(event.target.checked ? "true" : "false")
          }
        />
        <label htmlFor="onGoing">On going</label>
      </div>

      <p> Is this on a full-time or part-time basis?</p>
      <div>
        <input
          id="fullTime"
          type="radio"
          name="workingType"
          value="fullTime"
          checked={workingType === "fullTime"}
          onChange={(e) => setWorkingType(e.target.value)}
        />
        <label>Full-time </label>
      </div>
      <div>
        <input
          id="partTime"
          type="radio"
          name="workingType"
          value="partTime"
          checked={workingType === "partTime"}
          onChange={(e) => setWorkingType(e.target.value)}
        />
        <label>Part-time </label>
      </div>

      <div>
        <label> Hours per week</label>
        <input
          id="hoursPerWeek"
          type="number"
          name="hoursPerWeek"
          placeholder="20"
          min="20"
          max="38"
          required
          value={employee.hoursPerWeek}
          onChange={handleChange}
        />
      </div>

      {/* button:save and Cancel */}
      <div className={styles.buttonGroup}>
        <button
          type="submit"
          onClick={handleSubmit}
          className={`${styles.button} ${styles.saveButton}`}
        >
          Save
        </button>
        <button
          type="button"
          className={`${styles.button} ${styles.cancelButton}`}
        >
          Cancel
        </button>
      </div>
    </form>
  );
};

export default CreateEmployee;
