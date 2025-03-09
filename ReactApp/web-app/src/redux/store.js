// import { legacy_createStore as createStore } from 'redux';
// import counterReducer from './reducer';
 
// const store= createStore(counterReducer);
 
// export default store;


// import {createStore} from 'redux';
import { configureStore } from '@reduxjs/toolkit';
// import counterReducer from './reducer';
import counterReducer from './counterSlice';
 
// const store= createStore(counterReducer);
const store=
configureStore({
    reducer:{
    counter: counterReducer,
},
});
 
export default store;