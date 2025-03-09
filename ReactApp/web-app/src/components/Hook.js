import React ,{useState, useEffect} from "react";
 
function Hooks(){
    const[count, setCount] = useState(0);
 
    useEffect(()=> {
        console.log("Component re-rendered!");
    });
 
    return(
        <>
        <h2>Count : {count}</h2>
        <button onClick={()=> setCount(count+1)}>Increment</button>
        </>
    );
}
export default Hooks;