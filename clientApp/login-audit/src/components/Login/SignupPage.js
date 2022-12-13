import React,{useState,useEffect} from 'react';
import {Button, Col, Container, Form, Row} from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.css';
import {Link,useNavigate} from "react-router-dom";
import validateInfo from './validateInfo';
import './login.css';
import AuditService from '../../service/AuditService';
import Logo from './Logo.png';

function SignupPage (props) {
    const [validated, setValidated] = useState(false);
    const [dataIsCorrect, setDataIsCorrect] = useState(false)
    const [values, setValues] = useState({
        firstname: '',
        lastname: '',
        emailId: '',
        password: '',
        mobile: ''
    });
    const navigate = useNavigate();
    const registerUser = (data) => {
        AuditService.register(data)
            .then(response => {
                localStorage.setItem("userId", response.data);
                navigate.replace('/home');
                console.log(response.data);
            })
            .catch(e => {
                console.log(e);
            });

    };
    const handleChange = (e) => {
        setValues({ ...values, [e.target.name]: e.target.value })

    }
    
    const [errors, setErrors] = useState({});
    function submitHandler(event) {
        event.preventDefault();
        setErrors(validateInfo(values));
        setDataIsCorrect(true);
        setValidated(true);
    }
    useEffect(() => {
        console.log(Object.keys(errors).length)
        if (Object.keys(errors).length === 0 && dataIsCorrect) {
            registerUser(values);
        }
    },
        [errors]
    );
    return (
        <div className="center">
            <Container>
                <Row className="mt-5">
                    <Col lg={5} md={6} sm={12} className="card mx-auto">
                    <br/>
                        <div><p><img src={Logo} alt= "Logo" width="50px" height="50px"/></p></div>
                        <h2>Sign up</h2>
                        <h6>To access Rubix Books</h6>
                        <Form noValidate validated={validated}>
                            <Form.Group controlId="validationCustom01">
                                <Form.Label>First Name</Form.Label>
                                <Form.Control required name="firstname" type="text" placeholder="Enter Full Name" onChange={handleChange} value={values.firstname} />
                                {errors.firstname && <p className="error">{errors.firstname}</p>}
                            </Form.Group>

                            <Form.Group controlId="validationCustom02">
                                <Form.Label>Last Name</Form.Label>
                                <Form.Control required name="lastname" type="text" placeholder="Enter Last Name" onChange={handleChange} value={values.lastname}/>
                                {errors.lastname && <p className="error">{errors.lastname}</p>}
                            </Form.Group>

                            <Form.Group controlId="validationCustom03">
                                    <Form.Label>Email address</Form.Label>
                                    <Form.Control required name="emailId" type="email" placeholder="Enter email" onChange={handleChange} value={values.emailId}/>
                                    {errors.emailId && <p className="error">{errors.emailId}</p>}
                                </Form.Group>

                            <Form.Group controlId="formBasicPassword">
                                <Form.Label>Password</Form.Label>
                                <Form.Control required name="password" type="password" placeholder="Password" onChange={handleChange} value={values.password}/>
                                {errors.password && <p className="error">{errors.password}</p>}
                            </Form.Group>

                            <Form.Group controlId="validationCustom04">
                                <Form.Label>Mobile No</Form.Label>
                                <Form.Control required name="mobile" type="text" placeholder="Enter Mobile no" onChange={handleChange} value={values.mobile}/>
                                {errors.mobile && <p className="error">{errors.mobile}</p>}
                            </Form.Group>
                            <br/>
                            <Link to="/">
                            <Button variant="success btn-block" type="submit"  onClick={submitHandler}>
                                Sign Up
                            </Button>
                            </Link> 
                            <div style={{ marginTop: '20px' }} class="d-flex flex-row justify-content-center">
                                <div><h6>Already have a Rubix account?</h6></div>&nbsp;
                                <div><a href="/" style={{textDecoration: 'none'}}>Sign In Now</a></div>
                            </div> 
                        </Form>
                        <br/>
                    </Col>
                </Row>
            </Container>
        </div>
    );
};

export default SignupPage;