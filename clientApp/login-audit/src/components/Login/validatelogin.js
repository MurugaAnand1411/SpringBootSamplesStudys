export default function validatelogin(values) {
    let errors = {};
  
    if (!values.emailId) {
      errors.emailId = 'Email required';
    } else if (!/\S+@\S+\.\S+/.test(values.emailId)) {
      errors.emailId = 'Email address is invalid';
    }
   
    if (!values.password) {
      errors.password = 'Password is required';
    }
  
    return errors;
  }