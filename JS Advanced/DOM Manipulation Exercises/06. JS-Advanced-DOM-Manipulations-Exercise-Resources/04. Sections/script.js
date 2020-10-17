function create(words) {
   const divContent = document.querySelector('#content');

   if (divContent === null) {
      throw new Error('Something went wrong!');
   }

   words.map(word => {
      const div = document.createElement('div');
      const p = document.createElement('p');

      p.textContent = word;
      p.style.display = 'none';
      div.appendChild(p);
      divContent.appendChild(div);
   });

   divContent.addEventListener('click', e => {
      const p = e.target.firstElementChild;

      if (p.style.display === 'none') {
         p.style.display = 'block';
      } else {
         p.style.display = 'none';
      }
   });
}