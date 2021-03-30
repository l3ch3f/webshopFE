import axios from "axios";

export const handleLogin = (values) => {
  axios
    .post("/login", values)
    .then(function (response) {
      console.log(response);
    })
    .catch(function (error) {
      console.log(error);
    });
};
