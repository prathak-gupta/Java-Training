import React, {useState, useReducer} from 'react';
function reducer(state,action){
    switch(action.type){
        case "increment":
            return {count: state.count+1};
        case "decrement":
            return {count: state.count-1};
        case "reset":
            return {count: 0};
        default:
            return state;
    }
}
 
 
function ReducerCounter(){
    const[state, dispatch] = useReducer(reducer,{count:0});
 
    return(
        <>
            <h2>Count: {state.count}</h2>
            <button onClick={()=> dispatch({type: "increment"})}>Increment</button>
            <button onClick={()=> dispatch({type: "decrement"})}>Decrement</button>
            <button onClick={()=> dispatch({type: "reset"})}>Reset</button>
        </>
    )
}
 
 
export default ReducerCounter;
 