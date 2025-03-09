import React, { useState, useEffect } from 'react';
import axios from 'axios';
 
function PostList() {
    const [posts, setPosts] = useState([]);
 
    useEffect(() => {
        const fetchPosts = async () => {
            try {
                const response = await axios.get("https://jsonplaceholder.typicode.com/posts");
                setPosts(response.data);
            } catch (error) {
                console.error("Error fetching data: ", error);
            }
        };
        fetchPosts();
    }, []);
 
    return (
        <div>
            <h2>Post List</h2>
            <ul>
                {posts.slice(0, 10).map((post) => (
                    <li key={post.id}>{post.title} ({post.body})</li>
                ))}
            </ul>
        </div>
    );
}
 
export default PostList;