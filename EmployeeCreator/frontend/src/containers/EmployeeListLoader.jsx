import React, { useEffect, useState } from "react";
import EmployeeList from "../components/EmployeeList";
import { getAllEmployees } from "../services/employee-services";

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
        <EmployeeList posts={posts} filterPosts={filterPosts} />
      )}
      {!loading && error && <p style={{ color: "red" }}>{error.message}</p>}
    </>
  );
};

export default EmployeeListLoader;
