import React from 'react';
 
// function Welcome(props){
//     return(
//         <div>
//             <h1>Welcome {props.name}</h1>
//             <p>Happy to see you gain!</p>
//         </div>
//     );
// }
 
function Welcome({loggedIn}) {
    if(loggedIn) {
        return (
            <>
            <h1>Welcome to React App if logged in is true.</h1>
            <p>This is a simple component</p>
            {/* <h2>Hello, {props.name}</h2> */}
            </>
        )
    }
 
    else {
        return (
            <>
                <h1>Welcome Component if logged is in false</h1>
            </>
        );
    }
   
}
 
export default Welcome;
