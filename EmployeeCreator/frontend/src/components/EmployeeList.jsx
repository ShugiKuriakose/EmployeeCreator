import React from "react";
import Employee from "./Employee";

const EmployeeList = ({ posts, filterPosts }) => {
  return (
    <>
      {posts.map((post) => (
        <Employee post={post} filterPosts={filterPosts} />
      ))}
    </>
  );
};

export default EmployeeList;
