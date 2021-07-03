export const getCars = () => {
  return fetch("http://localhost:5000/api/cars/all").then((res) => res.json());
};
