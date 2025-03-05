import React from 'react';

function Notification({hasUnreadMsgs}){
    return(
        <>
        <h2>Welcome</h2>
        {hasUnreadMsgs && <p>You have unread msgs</p>}
        </>
    );
}
export default Notification;