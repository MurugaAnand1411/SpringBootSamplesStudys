import React,{useState} from 'react'
import {Button, Col, Container, Form, Row,ButtonGroup,ToggleButton} from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.css';
import {Link} from "react-router-dom";
import DatePicker from 'react-datepicker';
import "react-datepicker/dist/react-datepicker.css"

const Receipt = () => {
    const [radioValue, setRadioValue] = useState({});
    const [startDate, setStartDate] = useState(new Date());
  
    const radios = [
      { name: 'Done', value: '2' },
      { name: 'Fail', value: '3' },
    ];
  return (
    <div>
    <div className='center'>
        <Container>
                    <Row className="mt-5">
                        <Col lg={5} md={6} sm={12} className="card mx-auto">
                        <br/>
                        <h1 className='header'>Receipt</h1>
                            <Form>
                                <Form.Group controlId="formBasicEmail">
                                    <Form.Label>Receipt No</Form.Label>
                                    <Form.Control name="receiptId" type="text" placeholder="Enter Receipt No" />
                                </Form.Group>
                                
                                <br/>
                                <Form.Group controlId="formBasicEmail">
                                    <Form.Label>Select Date</Form.Label>
                                <DatePicker
                                    selected={startDate} onChange={(date) =>   
                                    setStartDate(date)}
                                />
                                </Form.Group>
                                
                                <br/>
                                <Form.Group controlId="formBasicEmail">
                                    <Form.Label>Amount</Form.Label>
                                    <Form.Control name="amount" type="text" placeholder="Enter Amount" />
                                </Form.Group>
                                
                                <br/>
                                <Form.Group controlId="formBasicEmail">
                                    <Form.Label>Paid To</Form.Label>
                                </Form.Group>
                                
                                <div style={{width: '150px'}}>
                                <Form.Select aria-label="Default select example">
                                    <option>--Select--</option>
                                    <option value="1">Clari 5</option>
                                    <option value="2">mLogica LLC</option>
                                    <option value="3">GLamz</option>
                                    <option value="4">Service Now</option>
                                  </Form.Select>
                                </div>

                                <br/>
                                <Form.Group controlId="formBasicEmail">
                                    <Form.Label>Status</Form.Label>
                                </Form.Group>

                                <ButtonGroup>
                                    {radios.map((radio, idx) => (
                                    <ToggleButton
                                        key={idx}
                                        id={`radio-${idx}`}
                                        type="radio"
                                        variant={idx % 2 ? 'outline-danger' : 'outline-success'}
                                        name="radio"
                                        value={radio.value}
                                        checked={radioValue === radio.value}
                                        onChange={(e) => setRadioValue(e.currentTarget.value)}
                                    >
                                        {radio.name}
                                    </ToggleButton>
                                    ))}
                                </ButtonGroup>
                                
                                <br/>
                                <br/>    
                                <Button variant="success btn-block" type="submit">
                                    Save
                                </Button> &nbsp;&nbsp;&nbsp;
                                <Link to="/home">
                                <Button variant="primary" >
                                    Home
                                </Button>
                                </Link>
                            </Form>
                        <br/>
                        </Col>
                    </Row>
                </Container>
              </div>
    </div>
  )
}

export default Receipt