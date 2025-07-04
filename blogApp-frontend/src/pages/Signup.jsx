import { Button, Card, CardBody, CardHeader, Container, Form, FormGroup, Input, Label } from "reactstrap";
import Base from "../components/Base";
import { useEffect, useState } from "react";
import { signUp } from "../services/userService";
import { toast } from "react-toastify";

const Signup=()=>{
    const [data, setData] = useState({
        username:'',
        email:'',
        password:'',
        role:'user',
    })

    useEffect(()=>{
        console.log(data);
    }, [data])

    const handleChange=(event, property)=>{
        setData({...data, [property]:event.target.value})
    }

    const [error, setError]=useState({
        errors: {},
        isError: false
    })

    const resetData=()=>{
        setData({
            name:'',
            email:'',
            password:'',
            role:'user',
        })
    }

    const submitForm =(event)=>{
        event.preventDefault()
        //data validate
        //call server api for sending data
        signUp(data).then((resp) => {
            console.log(resp);
            console.log("success");
            toast.success("User is registered successfully!");
        }).catch((error) => {
            console.log(error)
            console.log("Error");
        }); //promise does not work if error occurs
    }

    return (
        <Base>
            <Container>
                <Card className="mt-3" color="dark" inverse>
                    <CardHeader><h2>Fill the form to register</h2></CardHeader>
                    <CardBody>
                        <Form onSubmit={submitForm}>
                            <FormGroup>
                                <Label for="name">Username:</Label>
                                <Input id="username" type="text" placeholder="Enter your username here" onChange={(e)=> handleChange(e, 'username')} />
                            </FormGroup>
                            <FormGroup>
                                <Label for="email">Email:</Label>
                                <Input id="email" type="email" placeholder="Enter your email here" onChange={(e)=> handleChange(e, 'email')} />
                            </FormGroup>
                            <FormGroup>
                                <Label for="password">Password:</Label>
                                <Input is="password" type="password" placeholder="Enter your password here"onChange={(e)=> handleChange(e, 'password')} />
                            </FormGroup>
                            <FormGroup>
                                <Label for="role">Role:</Label>
                                <Input id="role" type="text" value="user" disabled />
                            </FormGroup>
                            <Container className="text-center">
                                <Button color="light" outline type="submit">Sign Up</Button>
                                <Button color="secondary" type="reset" className="ms-2" onClick={resetData}>Reset</Button>
                            </Container>                            
                        </Form>
                    </CardBody>
                </Card>
            </Container>
        </Base>
    );
};

export default Signup