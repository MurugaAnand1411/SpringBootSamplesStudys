import React,{useState,useEffect} from 'react'
import './login.css';
import {Button, Col, Container, Form, Row} from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.css';
import {Link,useNavigate} from "react-router-dom";
import validateInfo from './validateInfo';

const Forgot = () => {
        const [validated, setValidated] = useState(false);
        const [errors, setErrors] = useState({});
        const [dataIsCorrect, setDataIsCorrect] = useState(false);
        const [profile, setProfile] = useState({
            emailId: '',
            password: '',
            confirmpassword: ''
        });
        const navigate = useNavigate();
        const handleChange = (e) => {
          setProfile({ ...profile, [e.target.name]: e.target.value })
      }
      function submitHandler(event) {
        event.preventDefault();
        setErrors(validateInfo(profile));
        setDataIsCorrect(true);
        console.log(profile);
        //login(profile);
        setValidated(true);
    }
      useEffect(() => {
          if (Object.keys(errors).length === 0 && dataIsCorrect) {
              navigate("/", {replace: true})
              console.log(profile);
              //login(profile);
          }
      }, [errors]);

  return (
    <div className='center'>
        <Container>
                    <h1 className="shadow-sm mt-5 p-3 text-center rounded">Forgot Password?</h1>
                    <Row className="mt-5">
                        <Col lg={5} md={6} sm={12} className="p-5 m-auto shadow-sm rounded-lg">
                            <Form noValidate validated={validated}>
                            <Form.Group controlId="validationCustom01">
                                    <Form.Label>Email ID</Form.Label>
                                    <Form.Control required name="emailId" type="email" placeholder="Enter Email Id" onChange={handleChange} value={profile.emailId}/>
                                    {errors.emailId && <p className="error">{errors.emailId}</p>}
                                </Form.Group>

                                <br/>
                                <Form.Group controlId="formBasicPassword">
                                    <Form.Label>New Password</Form.Label>
                                    <Form.Control required name="password" type="password" placeholder="Enter New Password" onChange={handleChange} value={profile.password}/>
                                    {errors.password && <p className="error">{errors.password}</p>}
                                </Form.Group>

                                <br/>
                                <Form.Group controlId="formBasicPassword">
                                    <Form.Label>Confirm Password</Form.Label>
                                    <Form.Control required name="confirmpassword" type="password" placeholder="Enter Confirmed Password" onChange={handleChange} value={profile.confirmpassword}/>
                                    {errors.confirmpassword && <p className="error">{errors.confirmpassword}</p>}
                                </Form.Group>

                                <br/>
                                <Link to="/">    
                                <Button variant="success btn-block" type="submit" onClick={submitHandler}>
                                    Reset Password
                                </Button>
                                </Link> &nbsp;&nbsp;&nbsp;
                                <Link to="/">
                                <Button variant="primary" >
                                    Go to LogIn
                                </Button>
                                </Link>
                            </Form>
                        </Col>
                    </Row>
                </Container>
    </div>
  )
}

export default Forgot