import React, {useState} from 'react';
 
function LoginForm(){
    //Step 1: Define the state of form input
    const [formData, setFormData] = useState({
        name: '',
        email: '',
        password: ''
    });
 
    const handleChange = (event) => {
        const {name,value} = event.target;
        setFormData({
            ...formData,
            [name] : value
        })
    }
    // const [password, setPassword] = useState('');
 
 
    // //Step 2: Handle input changes
    // const handleEmailChange = (event) => {
    //     setEmail(event.target.value);
    // }
 
 
    // const handlePasswordChange = (event) => {
    //     setPassword(event.target.value);
    // }
 
    const handleSubmit = (event) => {
        event.preventDefault();
        // Process the form data (e.g., send it to a server)
        console.log('Form submitted:', formData);
    };
 
 
    return(
        <form onSubmit={handleSubmit}>
            <div>
                <label>Name:</label>
                <input
                    type="text"
                    name="name"
                    value={formData.name}
                    onChange={handleChange}
                />
            </div>
            <div>
                <label>Email:</label>
                <input
                    type="email"
                    name="email"
                    value={formData.email}
                    onChange={handleChange}
                />
            </div>
            <div>
                <label>Password:</label>
                <input
                    type="password"
                    name="password"
                    value={formData.password}
                    onChange={handleChange}
                />
            </div>
            <button type="submit">Submit</button>
        </form>
    );
}
 
 
export default LoginForm;
 