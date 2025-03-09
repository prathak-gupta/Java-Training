import React, { useState, useEffect } from 'react';
 
function UserList() {
    const [users, setUsers] = useState([]);
 
    useEffect(() => {
        const fetchUsers = async () => {
            try {
                const response = await fetch("https://jsonplaceholder.typicode.com/users");
                if (!response.ok) {
                    throw new Error("Failed to fetch users.");
                }
                const data = await response.json();
                setUsers(data);
            } catch (error) {
                console.error("Error fetching data: ", error);
            }
        };
        fetchUsers();
    }, []);
 
    return (
        <div>
            <h2>User List</h2>
            <ul>
                {users.map((user, index) => (
                    <li key={index}>{user.name}</li>
                ))}
            </ul>
        </div>
    );
}
 
export default UserList;
 