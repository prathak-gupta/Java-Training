import './App.css';
import Welcome from './components/Welcome';
import WelcomeClass from './components/WelcomeClass';
import Notification from './components/Notification';
import WelcomeDefault from './components/WelcomeDefault';
import LoginForm from './components/LoginForm';
import RadioButton from './components/RadioButton';
import CheckBox from './components/CheckBox.js';

function App() {
  const name = "Prathak";
  const num1 = 10;
  const num2 = 20;
  const loggedIn = true;
  const headingStyle = {
    color: 'white',
    fontSize: '50px',
    backgroundColor: 'red',
  };
  const gadgets = ['Mobile', 'Laptop', 'Headphone', 'PowerBank'];

  return (
    <div className="App">
      <RadioButton/>
      <CheckBox/>
      <LoginForm />
      <Welcome loggedIn />
      <WelcomeClass />
      <Notification hasUnreadMsgs={true} />
      <WelcomeDefault name="Prathak G." />
      <WelcomeDefault />
      <h1 style={headingStyle}>Hello {name}, from React App</h1>
      <p>Welcome to first code test.</p>
      <p>Sum of {num1} and {num2} is {num1 + num2}</p>
      <button onClick={() => alert('Clicked')}>Click Me</button>
      <h3>{loggedIn ? "Logged In" : "Please log in"}</h3>
      <ul>
        {gadgets.map((gadget, index) => (
          <li key={index}>{gadget}</li>
        ))}
      </ul>

    </div>
  );
}

export default App;
