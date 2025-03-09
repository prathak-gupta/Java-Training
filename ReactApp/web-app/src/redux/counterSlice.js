// import {createSlice} from "@reduxjs/toolkit";
// import { decrement, increment } from "./action";
 
// const initialState ={
//     counter:0,
// };
 
// const counterSlice = createSlice({
//     name:"counter",
//     reducers :{
//         increment:(state) =>{
//             state.counter +=1;
//         },
//         decrement: (state)=>{
//             state.counter -=1;
//         },
//     }
// });
 
// export const {increment,decrement}= counterSlice.actions;
 
// export default counterSlice.reducer;

// Replace action.js and reducer.js with counterSlice.js
 
import { createSlice } from "@reduxjs/toolkit";
 
const initialState = {
  count: 0,
};
 
// create Slice
const counterSlice = createSlice({
    name: "counter",
    initialState,
    reducers: {
        increment: (state) => {
            state.count += 1; // no need of return statement, immer.js takes care of it
        },
        decrement: (state) => {
            state.count -= 1;
        },
    }
});
 
// export actions
export const { increment, decrement } = counterSlice.actions;
 
// export reducer
export default counterSlice.reducer;
 