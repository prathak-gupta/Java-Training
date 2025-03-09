import React, { useState } from 'react';
import axios from 'axios';
 
function DeletePost() {
    const [postId, setPostId] = useState("");
 
    const handleDelete = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.delete(`https://jsonplaceholder.typicode.com/posts/${postId}`);
            console.log("Post deleted", response.data);
        } catch (error) {
            console.error("Error deleting post: ", error);
        }
    };
 
    return (
<div>
<h2>Delete Post</h2>
<form onSubmit={handleDelete}>
<label>Post ID</label>
<input type="text" value={postId} onChange={(e) => setPostId(e.target.value)} />
<button type="submit">Delete</button>
</form>
</div>
    );
}
 
export default DeletePost;