import React, { useEffect, useState } from "react";
import { NavLink } from "react-router-dom";
import EmployeeList from "../../components/EmployeeList";
import { getAllEmployees } from "../../services/employee-services";
import styles from "./EmployeeListLoader.module.scss";

const EmployeeListLoader = () => {
  const [posts, setPosts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  const filterPosts = (id) => {
    setPosts(posts.filter((post) => post.id !== id));
  };

  useEffect(() => {
    getAllEmployees()
      .then(setPosts)
      .catch(setError)
      .finally(() => setLoading(false));
  }, []);

  return (
    <>
      {loading && <p>Loading</p>}
      {!loading && !error && (
        <div>
          <h1>Employees' List</h1>
          <NavLink to={"/employees/new"}>
            <button className={styles.addempButton}>Add Employee</button>
          </NavLink>
          <hr />

          <EmployeeList posts={posts} filterPosts={filterPosts} />
        </div>
      )}
      {!loading && error && <p style={{ color: "red" }}>{error.message}</p>}
    </>
  );
};

export default EmployeeListLoader;
