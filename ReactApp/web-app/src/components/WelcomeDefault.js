function WelcomeDefault({name})
{
    return <h1>Welcome, {name || "Guest"}</h1>
}

export default WelcomeDefault;