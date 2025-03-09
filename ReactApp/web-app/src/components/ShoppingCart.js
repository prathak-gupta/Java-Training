import React, { useReducer } from 'react';
 
// Initial state
const initialState = [];
 
// Action types
const ADD_ITEM = 'ADD_ITEM';
const REMOVE_ITEM = 'REMOVE_ITEM';
const CLEAR_CART = 'CLEAR_CART';
 
// Cart reducer function
function cartReducer(state, action) {
    switch (action.type) {
        case ADD_ITEM:
            return [...state, action.item];
        case REMOVE_ITEM:
            return state.filter((_, index) => index !== action.item);
        case CLEAR_CART:
            return [];
        default:
            return state;
    }
}
 
// Shopping cart component
function ShoppingCart() {
    const [state, dispatch] = useReducer(cartReducer, initialState);
 
    return (
        <div>
            <h2>Shopping Cart</h2>
           
            <button onClick={() => dispatch({ type: ADD_ITEM, item: 'MacBook' })}>Add Laptop</button>
            <button onClick={() => dispatch({ type: ADD_ITEM, item: 'i-Pad' })}>Add Phone</button>
            <button onClick={() => dispatch({ type: CLEAR_CART })}>Empty Cart</button>
            <ul>
                {state.map((item, index) => (
                    <li key={index}>
                        {item}
                        <button onClick={() => dispatch({ type: REMOVE_ITEM, item: index })}>
                            Remove
                        </button>
                    </li>
                ))}
            </ul>
        </div>
    );
}
 
export default ShoppingCart;
 