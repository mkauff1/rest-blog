import createView from "../createView";

const BASE_URL = "http://localhost:8080/api/posts";
let requestMethod = "POST";
let postId = "";

export default function PostIndex(props) {
    // language=HTML
    return `
        <header>
            <h1>Posts Page</h1>
        </header>
        <main>
            <div id="posts-container">
                ${props.posts.map(post => `<h3> id="title-${post.id}">${post.title}</h3>
                                            <p id="content-${post.id}">${post.content}</p>
                <button type="submit" class="btn btn-primary edit-button" data-id="${post.id}">Edit</button>
                <button type="submit" class="btn btn-danger delete-button" data-id="${post.id}">Delete</button>
                `).join('')}   
            </div>
            <div id="add-post-form">
                <div>
                    <input type="text" class="form-control" id="add-post-title" placeholder="Add Post Title">
                </div>
                <br>
                <div>
                    <textarea class="form-control" rows="4" id="add-post-content"
                              placeholder="Add Post Content"></textarea>
                </div>
                <br>
                <div>
                    <button type="submit" class="btn btn-primary" id="submit-btn">Submit</button>
                </div>
            </div>
        </main>
    `;
}

export function PostsEvent() {
    createSubmitPostListener();
    createEditPostListener();
    createDeletePostListener();
}

function create

function createEditPostListener() {
    $(document).on("click", ".edit-button", function(e){
        e.preventDefault();
        postId = $(this).data("id");
        requestMethod = "PUT";
        console.log(postId);
    })
}