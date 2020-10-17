function solve() {
   const createButton = document.querySelector('button.btn.create');

   if (createButton === null) {
      throw new TypeError('Create Button not found!');
   }

   createButton.addEventListener('click', e => createArticle(e));

   function createArticle(e) {
      e.preventDefault();

      const author = document.querySelector('#creator').value;
      const title = document.querySelector('#title').value;
      const category = document.querySelector('#category').value;
      const content = document.querySelector('#content').value;

      if (author.trim() === '' || title.trim() === '' || category.trim() === '' || content.trim() === '') {
         throw new Error('You can not create an empty article!');
      }

      const article = document.createElement('article');

      createTitle(title, article);
      createParagraph(category, 'Category:', article);
      createParagraph(author, 'Creator:', article);
      createContent(content, article);
      createButtons(article);

      const section = document.querySelector('main section');
      section.appendChild(article);
   }

   function createTitle(title, article) {
      const h1 = document.createElement('h1');
      h1.textContent = title;
      article.appendChild(h1);
   }

   function createParagraph(content, text, article) {
      const strong = document.createElement('strong');
      strong.textContent = content;

      const p = document.createElement('p');
      p.textContent = text;
      p.appendChild(strong);
      article.appendChild(p);
   }

   function createContent(content, article) {
      const p = document.createElement('p');
      p.textContent = content;
      article.appendChild(p);
   }

   function createButtons(article) {
      const div = document.createElement('div');
      div.className = 'buttons';

      const deleteBtn = document.createElement('button');
      deleteBtn.className = 'btn delete';
      deleteBtn.textContent = 'Delete';
      div.appendChild(deleteBtn);
      deleteBtn.addEventListener('click', deleteArticle);

      const archiveBtn = document.createElement('button');
      archiveBtn.className = 'btn archive';
      archiveBtn.textContent = 'Archive';
      div.appendChild(archiveBtn);
      archiveBtn.addEventListener('click', archiveArticle);

      article.appendChild(div);
   }

   function deleteArticle(e) {
      e.target.parentElement.parentElement.remove();
   }

   function archiveArticle(e) {
      const ul = document.querySelector('.archive-section ul');

      const li = document.createElement('li');
      li.textContent = e.target.parentElement.parentElement.children[0].textContent;
      ul.appendChild(li);

      let items = ul.querySelectorAll('li');

      ul.innerHTML = '';

      Array.from(items)
         .sort((f, s) => f.textContent.localeCompare(s.textContent))
         .map(item => ul.appendChild(item));

      e.target.parentElement.parentElement.remove();
   }
}

