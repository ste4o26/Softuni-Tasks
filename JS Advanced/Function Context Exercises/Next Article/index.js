function getArticleGenerator(articles) {
    const button = document.querySelector('button');
    const divContent = document.querySelector('#content');

    if (button === null || content === null) {
        throw new Error('Something went wrong!');
    }
    return function displayNextArticle() {
        if (articles.length === 0) return; //throw new Error('There are no more articles to display!'); raboti s return no e po dobre da hvurlq greshka
        const article = document.createElement('article');
        const paragraph = document.createElement('p');

        paragraph.textContent = articles.shift();
        article.appendChild(paragraph);
        divContent.appendChild(article);
    }
}