import { Card, CardBody, CardHeader, Container, Form, FormGroup, Input, Label, Button } from "reactstrap";
import Base from "../components/Base";

const Login = () => {
    return (
        <Base>
            <Container>
                <Card className="mt-3" color="dark" inverse>
                    <CardHeader><h2>Login to Your Account</h2></CardHeader>
                    <CardBody>
                        <Form>
                            <FormGroup>
                                <Label for="email">Email:</Label>
                                <Input id="email" type="email" placeholder="Enter your email here" />
                            </FormGroup>
                            <FormGroup>
                                <Label for="password">Password:</Label>
                                <Input id="password" type="password" placeholder="Enter your password here" />
                            </FormGroup>
                            <Container className="text-center">
                                <Button color="light" outline type="submit">Login</Button>
                            </Container>                            
                        </Form>
                    </CardBody>
                </Card>
            </Container>
        </Base>
    );
};

export default Login;
