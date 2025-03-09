import './App.css';
import Welcome from './components/Welcome';
import WelcomeClass from './components/WelcomeClass';
import Notification from './components/Notification';
import WelcomeDefault from './components/WelcomeDefault';
import LoginForm from './components/LoginForm';
import RadioButton from './components/RadioButton';
import CheckBox from './components/CheckBox.js';
import ListKey from './components/ListKey.js';
import MessageHook from './components/MessageHook.js';
import Hooks from './components/Hook.js';
import ReducerCounter from './components/ReduceCounter.js';
import ShoppingCart from './components/ShoppingCart.js';
import Home  from './components/Home.js';
import Contact from './components/Contact.js';
import About from './components/About.js';
import User from './components/User.js';
import Dashboard from './components/Dashboard.js';
import Settings from './components/Settings.js';
import Profile from './components/Profile.js';

import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import UserList from './components/UserList.js';
import PostList from './components/PostList.js';
import CreatePost from './components/CreatePost.js';
import UpdatePost from './components/UpdatePost.js';
import DeletePost from './components/DeletePost.js';
import CounterButtons from './components/CounterButtons.js';
import CounterDisplay from './components/CounterDisplay.js';

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
  const employees = [
    {id :1, name:'temp1',active:true},
  {id :2, name:'temp2',active:false},
  {id :3, name:'temp3',active:true}
  ]
  return (
    <div className="App">
            <CounterButtons/>
            <CounterDisplay/>
      <Router>
      <nav>
        <ul>
          <li><Link to="/">Home</Link></li>
          <li><Link to="/about">About</Link></li>
          <li><Link to="/contact">Contact</Link></li>
          <li><Link to="/user/:Prathak">User1</Link></li>
          <li><Link to="/user/:Bittu">User2</Link></li>
          <li><Link to="/dashboard">Dashboard</Link></li>
          <li><Link to="/userlist">User List</Link></li>
          <li><Link to="/postlist">Post List</Link></li>
          <li><Link to="/postlist">Post List</Link></li>
          <li><Link to="/createpost">Create Post</Link></li>
          <li><Link to="/updatepost">Update Post</Link></li>
          <li><Link to="/deletepost">Delete Post</Link></li>
          </ul>
      </nav>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path="/contact" element={<Contact />} />
        <Route path="/user/:username" element={<User />} />
        <Route path="/user/:username" element={<User />} />
        <Route path="/dashboard" element={<Dashboard />}/>
          <Route path="/profile" element={<Profile />} />
          <Route path="/setting" element={<Settings />} />
          <Route path="/userlist" element={<UserList />}/>
          <Route path="/postlist" element={<PostList />}/>
          <Route path="/createpost" element={<CreatePost />}/>
          <Route path="/updatepost" element={<UpdatePost />}/>
          <Route path="/deletepost" element={<DeletePost />}/>
          </Routes>
      
    </Router>
      {/* {employees.map((emp,ind)=>{
        return <ListKey key={emp.id} name={emp.name}/>
      })}
      {employees.filter((emp)=>emp.active).map((emp,ind)=>{
        return <ListKey key={emp.id} name={emp.name}/>
      })} */}
      {/* <ShoppingCart/>
      <ReducerCounter/>
        <MessageHook text="Happy Birthday!!"/>
        <Hooks/>
      <ListKey/>
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
      </ul> */}

    </div>
  );
}

export default App;
