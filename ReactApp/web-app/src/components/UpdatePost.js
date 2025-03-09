import React, { useState } from 'react';
import axios from 'axios';
 
function UpdatePost() {
    const [postId, setPostId] = useState("");
    const [title, setTitle] = useState("");
    const [body, setBody] = useState("");
 
    const handleUpdate = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.put(`https://jsonplaceholder.typicode.com/posts/${postId}`, {
                title,
                body,
                userId: 1
            });
            console.log("Post updated", response.data);
        } catch (error) {
            console.error("Error updating post: ", error);
        }
    };
 
    return (
<div>
<h2>Update Post</h2>
<form onSubmit={handleUpdate}>
<label>Post ID</label>
<input type="text" value={postId} onChange={(e) => setPostId(e.target.value)} />
<label>Title</label>
<input type="text" value={title} onChange={(e) => setTitle(e.target.value)} />
<label>Body</label>
<textarea value={body} onChange={(e) => setBody(e.target.value)}></textarea>
<button type="submit">Update</button>
</form>
</div>
    );
}
 
export default UpdatePost;