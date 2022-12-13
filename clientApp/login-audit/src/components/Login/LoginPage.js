    import React,{useState,useEffect} from 'react';
    import {Button, Col, Container, Form, Row} from "react-bootstrap";
    import 'bootstrap/dist/css/bootstrap.css';
    import {Link,useNavigate} from "react-router-dom";
    import validatelogin from './validatelogin';
    import  './login.css';
    import AuditService from '../../service/AuditService';
    import Logo from './Logo.png';

    function LoginPage (props) {
        const [validated, setValidated] = useState(false);
        const [errors, setErrors] = useState({});
        const [dataIsCorrect, setDataIsCorrect] = useState(false);
        const [profile, setProfile] = useState({
            emailId: '',
            password: ''
        });
        const navigate = useNavigate();
        const login = (data) => {
            AuditService.login(data)
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
            setProfile({ ...profile, [e.target.name]: e.target.value })
        }
        function submitHandler(event) {
            event.preventDefault();
            setErrors(validatelogin(profile));
            setDataIsCorrect(true);
            setValidated(true);
            console.log(profile);
            login(profile);
        }
        useEffect(() => {
            if (Object.keys(errors).length === 0 && dataIsCorrect) {
                navigate("/home", {replace: true})
                console.log(profile);
                login(profile);
            }
        }, [errors]);
        return (
            
            <div className="center">
                <Container>
                    <Row className="mt-5">
                        <Col lg={5} md={6} sm={12} className="card mx-auto">
                        <br/> 
                        <div><p><img src={Logo} alt= "Logo" width="50px" height="50px"/></p></div>   
                        <h2>Sign in</h2>
                        <h6>To access Rubix Books</h6>
                            <Form noValidate validated={validated}>
                                <Form.Group controlId="validationCustom01">
                                    <Form.Label>Email address</Form.Label>
                                    <Form.Control required name="emailId" type="email" placeholder="Enter email" onChange={handleChange} value={profile.emailId}/>
                                    {/* {errors.emailId && <p className="error">{errors.emailId}</p>} */}
                                    <Form.Control.Feedback type="invalid">
                                        Please provide valid Email ID
                                    </Form.Control.Feedback>
                                </Form.Group>

                                <Form.Group controlId="formBasicPassword">
                                    <Form.Label>Password</Form.Label>
                                    <Form.Control required name="password" type="password" placeholder="Password" onChange={handleChange} value={profile.password}/>
                                    {/* {errors.emailId && <p className="error">{errors.password}</p>} */}
                                    <Form.Control.Feedback type="invalid">
                                        Please provide valid Password
                                    </Form.Control.Feedback>
                                </Form.Group>

                                <br/>
                                <Link to="/home">    
                                <Button variant="success btn-block" type="submit" onClick={submitHandler}>
                                    Login
                                </Button>
                                </Link>
                                <br/>
                                <br/>
                                <div>
                                <Link to="/forgot-password">
                                <Button variant="dark btn-block">
                                     Forgot password?
                                </Button>
                                </Link>
                                </div>
                            <div style={{ marginTop: '20px' }} class="d-flex flex-row justify-content-center">
                                <div><h6>Don't have a Rubix account?</h6></div>&nbsp;
                                <div><a href="/signup" style={{textDecoration: 'none'}}>Sign Up Now</a></div>
                            </div>
                            </Form>
                            <br/>
                        </Col>
                    </Row>
                </Container>
            </div>
            
        );
    };

    export default LoginPage;