import React from "react";
import { deleteEmployeeById } from "../../services/employee-services";
import styles from "./Employee.module.scss";

const Employee = ({ post, filterPosts }) => {
  const onClick = (e) => {
    deleteEmployeeById(post.id)
      .then((response) => filterPosts(post.id))
      .catch((error) => console.error(error.message));
  };
  return (
    <div className={styles.empCard}>
      <h2>{post.name}</h2>
      <p>
        {post.employmentType} - {post.yearsEmployed}yrs
      </p>
      <p>{post.email}</p>
      <button className={styles.empButton} onClick={onClick}>
        Edit
      </button>
      <button className={styles.empButton} onClick={onClick}>
        Remove
      </button>
      <hr />
    </div>
  );
};
export default Employee;
