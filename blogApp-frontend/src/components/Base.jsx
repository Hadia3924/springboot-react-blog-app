import NavbarCust from "./NavbarCust";

const Base = ({title = "Welcome to Blog App", children}) => {
    return(
        <div className="container-fluid p-0 m-0">
            <NavbarCust/>
            {children}
            <h1>This is the footer</h1>
        </div>
    );
};

export default Base;