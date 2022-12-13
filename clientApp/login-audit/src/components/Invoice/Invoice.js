import React,{useState} from 'react'
import {Button, Col, Container, Form, Row} from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.css';
import {Link} from "react-router-dom";
import DatePicker from 'react-datepicker';
import "react-datepicker/dist/react-datepicker.css"
import './invoice.css'

const Invoice = () => {
    const [startDate, setStartDate] = useState(new Date());
  
  return (
    <div>
    <div className='center'>
        <Container>
                    <Row className="mt-5">
                        <Col lg={5} md={6} sm={12} className="card mx-auto">
                        <br/>
                        <h1 className='header'>Invoice</h1>
                            <Form>
                                <Form.Group controlId="formBasicEmail">
                                    <Form.Label>Invoice#</Form.Label>
                                    <Form.Control name="receiptId" type="text" placeholder="Enter Invoice No" />
                                </Form.Group>
                                
                                <br/>
                                <Form.Group controlId="formBasicEmail">
                                    <Form.Label>Invoice Date</Form.Label>
                                <DatePicker
                                    selected={startDate} onChange={(date) =>   
                                    setStartDate(date)}
                                />
                                </Form.Group>
                                
                                <br/>
                                <Form.Group controlId="formBasicEmail">
                                    <Form.Label>Amount(Without Tax)</Form.Label>
                                    <Form.Control name="amount" type="text" placeholder="Enter Amount" />
                                </Form.Group>

                                <br/>
                                <Form.Group controlId="formBasicEmail">
                                    <Form.Label>Tax</Form.Label>
                                </Form.Group>

                                <div style={{width: '150px'}}>
                                <Form.Select aria-label="Default select example">
                                    <option>%</option>
                                    <option value="1">Non Taxable</option>
                                    <option value="2">IGST0 [0%]</option>
                                    <option value="3">IGST5 [5%]</option>
                                    <option value="4">IGST12 [12%]</option>
                                    <option value="5">IGST18 [18%]</option>
                                    <option value="6">IGST28 [28%]</option>
                                    <option value="7">GST0 [0%]</option>
                                    <option value="8">GST5 [5%]</option>
                                    <option value="9">GST12 [12%]</option>
                                    <option value="10">GST18 [18%]</option>
                                    <option value="11">GST28 [28%]</option>
                                  </Form.Select>
                                  </div>

                                  <br/>
                                <Form.Group controlId="formBasicEmail">
                                    <Form.Label>Amount(With Tax)</Form.Label>
                                    <Form.Control name="amount" type="text" placeholder="Enter Amount" />
                                </Form.Group>

                                <br/>
                                <Form.Group controlId="formBasicEmail">
                                    <Form.Label>Customer</Form.Label>
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
                                    <Form.Label>Payment Term</Form.Label>
                                </Form.Group>

                                <div style={{width: '160px'}}>
                                <Form.Select aria-label="Default select example">
                                    <option>--Select--</option>
                                    <option value="1">Custom</option>
                                    <option value="2">Due on Receipt</option>
                                    <option value="3">Net 15</option>
                                    <option value="4">Net 30</option>
                                    <option value="5">Net 45</option>
                                    <option value="6">Net 60</option>
                                  </Form.Select>
                                  </div>
                                
                                <br/>
                                <Form.Group controlId="formBasicEmail">
                                    <Form.Label>Due Date</Form.Label>
                                <DatePicker
                                    selected={startDate} onChange={(date) =>   
                                    setStartDate(date)}
                                />
                                </Form.Group>

                                <br/>
                                <Form.Group controlId="formBasicEmail">
                                    <Form.Label>Payment Type</Form.Label>
                                </Form.Group>

                                <div style={{width: '150px'}}>
                                <Form.Select aria-label="Default select example">
                                    <option>--Select--</option>
                                    <option value="1">Cash</option>
                                    <option value="2">IMPS</option>
                                    <option value="3">RTGS</option>
                                    <option value="4">NEFT</option>
                                  </Form.Select>
                                  </div> 
                                
                                <br/>    
                                <Button variant="success btn-block" type="submit">
                                   Generate PDF
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

export default Invoice