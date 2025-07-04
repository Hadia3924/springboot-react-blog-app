import { myAxios } from "./helper";

export const signUp = (user) => {
    return myAxios
    .post("/api/users/register", user, {
        headers: {
            "Content-Type": "application/json"
        }
    })
    .then((response) => response.data); // returns promise, then returns signup data
};