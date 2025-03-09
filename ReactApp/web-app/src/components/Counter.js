import React, { useState } from "react";
const Counter = () => {
 
const[count, setCount] = useState(0);
 
return (
     <>
        <h2 data-testid="counter-value"> Count : {count}</h2>
        <button data-testid="increment-button" onClick={() => setCount(count + 1)}>Increment</button>
        <button data-testid="decrement-button" onClick={() => setCount(count - 1)}>Decrement</button>
        <button data-testid="reset-button" onClick={() => setCount(0)}>Reset</button>
 
     </>
    );
};
 
export default Counter;
 