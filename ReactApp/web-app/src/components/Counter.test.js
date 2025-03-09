import {fireEvent, render, screen} from '@testing-library/react';
import Counter from './Counter';
 
 
//Test 1
test("renders Counter component", () => {
    render(<Counter/>);
    const counterText = screen.getByTestId(/Count/i);
    expect(counterText).toBeInTheDocument();
});
 
 
//Test 2
test("Initial Counter is 0", () => {
    render(<Counter/>);
    const counterText = screen.getByTestId("counter-value");
    expect(counterText).toHaveTextContent("Count : 0");
});
 
 
//Test 3
test("Increment button increments the counter value by 1", () => {
    render(<Counter/>);
    const counterText = screen.getByTestId("counter-value");
    const incrementBtn = screen.getByTestId("increment-button");
    fireEvent.click(incrementBtn);
    expect(counterText).toHaveTextContent("Count : 1");
 
});
//Test 4
test("Increment button increments the counter value by 1", () => {
    render(<Counter/>);
    const counterText = screen.getByTestId("counter-value");
    const decrementBtn = screen.getByTestId("decrement-button");
    fireEvent.click(decrementBtn);
    expect(counterText).toHaveTextContent("Count : -1");
 
});
//Test 5
test("Increment button increments the counter value by 1", () => {
    render(<Counter/>);
    const counterText = screen.getByTestId("counter-value");
    const resetBtn = screen.getByTestId("reset-button");
    fireEvent.click(resetBtn);
    expect(counterText).toHaveTextContent("Count : 0");
 
});
 