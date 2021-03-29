import { Formik, Field, Form, ErrorMessage } from "formik";
import TextField from "@material-ui/core/TextField";
import { Button } from "@material-ui/core";
import * as Yup from "yup";
import { handleLogin } from "../components/custom-hooks/useLogin";

const LoginPage = () => {
  return (
    <Formik
      initialValues={{ email: "", password: "" }}
      validationSchema={Yup.object({
        email: Yup.string().email("Invalid email address").required("Required"),
        password: Yup.string().min(8, "Invalid").required("Required"),
      })}
      onSubmit={(values, { setSubmitting }) => {
        setTimeout(() => {
          // alert(JSON.stringify(values, null, 2));
          handleLogin(JSON.stringify(values, null, 2));
          setSubmitting(false);
        }, 400);
      }}
    >
      <Form>
        <label htmlFor="email">Email Address: </label>

        <Field name="email" type="email" as={TextField} placeholder="Email" />

        <ErrorMessage name="email" />
        <label htmlFor="password">Password: </label>

        <Field
          name="password"
          type="password"
          as={TextField}
          placeholder="Password"
        />

        <ErrorMessage name="password" />

        <Button type="submit">Submit</Button>
      </Form>
    </Formik>
  );
};

export default LoginPage;
