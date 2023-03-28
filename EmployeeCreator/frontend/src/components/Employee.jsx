import React from "react";
import { deleteEmployeeById } from "../services/employee-services";

const Employee = ({ post, filterPosts }) => {
  const onClick = (e) => {
    deleteEmployeeById(post.id)
      .then((response) => filterPosts(post.id))
      .catch((error) => console.error(error.message));
  };
  return (
    <div style={{ border: "1px solid black" }}>
      <h2>{post.title}</h2>
      <p>{post.content}</p>
      <button onClick={onClick}>Delete Post</button>
    </div>
  );
};
export default Employee;
