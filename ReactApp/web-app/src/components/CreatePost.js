import React, { useState } from 'react';
import axios from 'axios';
 
function CreatePost() {
    const [title, setTitle] = useState("");
    const [body, setBody] = useState("");
 
    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post("https://jsonplaceholder.typicode.com/posts", {
                title,
                body,
                userId: 1
            });
            console.log("Post created", response.data);
        } catch (error) {
            console.error("Error creating post: ", error);
        }
    };
 
    return (
        <div>
            <h2>Create Post</h2>
            <form onSubmit={handleSubmit}>
                <label>Title</label>
                <input type="text" value={title} onChange={(e) => setTitle(e.target.value)} />
                <label>Body</label>
                <textarea value={body} onChange={(e) => setBody(e.target.value)}></textarea>
                <button type="submit">Submit</button>
            </form>
        </div>
    );
}
 
export default CreatePost;
 
 