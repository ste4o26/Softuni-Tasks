function createArticle() {
	let h3 = document.createElement("h3");
	let p = document.createElement("p");
	let article = document.createElement("article");

	let input = document.getElementById("createTitle");
	let textarea = document.getElementById('createContent');
	let articlesList = document.getElementById("articles");

	if (input === null || textarea === null || articlesList === null) {
		throw new Error('One or more of needed HTML elements do not exist!');
	}

	if (input.value !== '' && textarea.value !== '') {
		h3.textContent = input.value;
		p.textContent = textarea.value;

		article.appendChild(h3);
		article.appendChild(p);

		articlesList.appendChild(article);
	}
	//onclick="createArticle()"
	input.value = '';
	textarea.value = '';
}


document
	.getElementById('createArticleButton')
	.addEventListener('click', createArticle);