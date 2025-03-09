import React ,{useState, useEffect} from "react";
 
function MessageHook({text}){
   
 
    useEffect(()=> {
        console.log(`Message Updates : ${text}`);
    },[text]);
 
    return(
        <>
        <h2>{text}</h2>
       
        </>
    );
}
export default MessageHook;