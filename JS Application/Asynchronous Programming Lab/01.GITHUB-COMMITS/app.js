// function loadCommits() {
//     // Try it with Fetch API
//     const username = document.querySelector('#username').value;
//     const repository = document.querySelector('#repo').value;
//     const ul = document.querySelector('#commits');
//     const url = `https://api.github.com/repos/${username}/${repository}/commits`;

//     ul.textContent = '';
//     fetch(url, { method: 'GET' })
//         .then(response => {
//             if (response.status >= 400) {
//                 throw new Error(`Error: ${response.status} (${response.statusText})`);
//             }

//             return response.json();
//         })
//         .then(data => {
//             data.map(item => {
//                 const li = document.createElement('li');
//                 li.textContent = `${item.commit.author.name}: ${item.commit.message}`;
//                 ul.appendChild(li);
//             });
//         })
//         .catch(error => {
//             const li = document.createElement('li');
//             li.textContent = error.message; 
//             ul.appendChild(li);
//         });
// }

//async await syntax!!!
async function loadCommits() {
    const username = document.querySelector('#username').value;
    const repository = document.querySelector('#repo').value;
    const url = `https://api.github.com/repos/${username}/${repository}/commits`;

    const ul = document.querySelector('#commits');
    ul.textContent = '';

    try {
        let response = await fetch(url);

        if (response.status >= 400) {
            throw new Error(`Error: ${response.status} (${response.statusText})`);
        }

        const data = await response.json();
        console.log(data);
        data.map(item => {
            const li = document.createElement('li');
            li.textContent = `${item.commit.author.name}: ${item.commit.message}`;
            ul.appendChild(li);
        });

    } catch (error) {
        const li = document.createElement('li');
        li.textContent = error.message;
        ul.appendChild(li);
    }
}
