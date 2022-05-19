export default function UserIndex(props) {
    //language=HTML
    return `
        <header>
            <h1>Welcome, ${props.user.username}</h1>
        </header>
        <main>
            <form id="user-info-form">
                <label for="email">Email</label>
                <input disabled id="email" name="email" type="email" value="${props.user.email}">
                <label for="new-password">New Password</label>
                <input id="new-password" name="new-password" type="password" value="this is not your real password"/>
                <button id="change-password-button" data-id="$${props.user.id}" type="button">Change Password</button>
            </form>
        </main>`
}

export function UserEvent(){
    addUpdatePasswordListener();
}

function addUpdatePasswordListener() {
    $(document).on('click', '#change-password-button', function (e) {
        e.preventDefault()
        const id = $(this).data("id");
        const newPassword = $("#new-password").val();
        const request = {
            method: "PUT",
            headers: {
                'Content-Type': 'application/json'
            }
        }
        fetch(`${BASE_URL}/${id}/updatePassword?newPassword=${newPassword}`, request)
            .then(res => {
                console.log(res.status);
            }).then(data => {
                console.log(data);
            }).catch(err => console.log(err));
    })
}