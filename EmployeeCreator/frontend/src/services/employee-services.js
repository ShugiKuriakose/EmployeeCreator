export const getAllEmployees = async () => {
  const response = await fetch("http://localhost:8080/posts");
  return await response.json();
};

export const deleteEmployeeById = async (id) => {
  const response = await fetch("http://localhost:8080/posts/" + id, {
    method: "DELETE",
  });
  if (!response.ok) {
    throw new Error("Couldn't find post with id " + id);
  }

  return await true;
};

export const createEmployee = async (postData) => {
  const response = await fetch("http://localhost:8080/posts", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(postData),
  });
  if (!response.ok) {
    console.log(await response.json());
    throw new Error("failed to create post");
  }
  return await response.json();
};
