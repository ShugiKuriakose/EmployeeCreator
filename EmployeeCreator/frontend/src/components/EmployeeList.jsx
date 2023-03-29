import React from "react";
import Employee from "./EmployeeCard/Employee";

const EmployeeList = ({ posts, filterPosts }) => {
  return (
    <>
      {posts.map((post) => (
        <Employee key={post.id} post={post} filterPosts={filterPosts} />
      ))}
    </>
  );
};

export default EmployeeList;
