// import React from "react";
// import { useSelector } from "react-redux";
 
// const CounterDisplay=()=>{
//     const count = useSelector(state=>state.count);
//     return(
//         <div>
//             <h1>Counter Value: {count}</h1>
//         </div>
//     )
// };
// export default CounterDisplay;

import React from "react";
import { useSelector } from "react-redux";
 
const CounterDisplay=()=>{
    const count = useSelector(state=>state.counter.count);
    return(
        <div>
            <h1>Counter Value: {count}</h1>
        </div>
    )
};
export default CounterDisplay;
 