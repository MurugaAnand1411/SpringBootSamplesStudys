export default function validateInfo(values) {
    var regEx = /^[0-9a-zA-Z]+$/;
    let errors = {};

    if (!values.firstname) {
      errors.firstname = 'Firstname required';
    }

    if (!values.lastname) {
      errors.lastname = 'Lastname required';
    }
  
    if (!values.name) {
      errors.name = 'Username required';
    }
    else if (!/^[A-Za-z]+/.test(values.name.trim())) {
      errors.name = 'Enter a valid name';
    }
  
    if (!values.emailId) {
      errors.emailId = 'Email required';
    } else if (!/\S+@\S+\.\S+/.test(values.emailId)) {
      errors.emailId = 'Email address is invalid';
    }
    if (!values.mobile) {
      errors.mobile = 'MobileNo required';
    } else if (!/^[0-9]+$/.test(values.mobile)) {
      errors.mobile = 'Enter the valid mobile no';
    }
    if (!values.password) {
      errors.password = 'Password is required';
    } else if (values.password.length < 8) {
      errors.password = 'Password needs to be 8 characters or more';
    } else if (values.password.match(regEx)) {
      errors.password = 'Password should contain atleast one number and one special character';
    }
  
    if (!values.confirmpassword) {
      errors.confirmpassword = 'Password is required';
    } else if (values.confirmpassword !== values.password) {
      errors.confirmpassword = 'Passwords do not match';
    }
    return errors;
  }
 
  
  