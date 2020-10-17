function loadRepos() {
	const button = document.querySelector('button');
	const input = document.querySelector('input');
	const ul = document.querySelector('#repos');

	if (button === null || input === null || ul === null) {
		throw new TypeError('Something went wrong!');
	}

	while (ul.firstElementChild !== null) {
		ul.firstElementChild.remove();
	}


	let url = `https://api.github.com/users/${input.value}/repos`;

	fetch(url)
		.then(response => {
			//dobra praktika e da ne prikrivam greshkata i nqkakva pomoshtna dokumentaciq kum neq zashtoto posle po trudno shte se debugva
			if (!response.ok && response.status !== 404) {
				throw new Error(`${response.status} ${response.statusText}`)
			}
			return response.json();
		})
		.then(handleErrorNonExistingUser)
		.then(data => data.map(fetchNameAndUrl))
		.then(data => data.map(displayFormatedOutputToDOM))
		.catch(console.err)
}

function handleErrorNonExistingUser(data) {
	if (data.documentation_url) {
		throw new Error(`${data.message} => ${data.documentation_url}`);
	}

	return data;
}

function fetchNameAndUrl(item) {
	return [item.full_name, item.html_url];
}

function displayFormatedOutputToDOM(item) {
	const ul = document.querySelector('#repos');
	const li = document.createElement('li');
	const a = document.createElement('a');

	[a.textContent, a.href] = item;

	li.appendChild(a);
	ul.appendChild(li);
}

