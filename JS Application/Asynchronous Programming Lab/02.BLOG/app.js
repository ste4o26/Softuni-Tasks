function attachEvents() {
    const loadButton = document.querySelector('#btnLoadPosts');
    const viewButton = document.querySelector('#btnViewPost');
    const postTitle = document.querySelector('#post-title');
    const postBody = document.querySelector('#post-body');
    const url = `https://blog-apps-c12bf.firebaseio.com/posts`;

    if (loadButton === null || viewButton === null || postBody === null || postTitle === null) {
        throw new TypeError('Something went wrong!');
    }

    loadButton.addEventListener('click', e => {
        fetch(url)
            .then(data => console.log('Heloo: ' + data))
            .catch(err => console.error('My error ' + err.message));
    })

}

attachEvents();