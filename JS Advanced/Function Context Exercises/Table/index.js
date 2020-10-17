function solve() {
   const tbody = document.querySelector('tbody');

   if (tbody === null) {
      throw new Error('Something went wrong!');
   }

   tbody.addEventListener('click', e => {
      const tr = e.target.parentElement;

      const previousTr = Array
         .from(tbody.rows)
         .find(row => row.style.background === 'rgb(65, 63, 94)');

      if (tr.style.background === '') {
         tr.style.background = '#413f5e';
         
         if (previousTr !== undefined) {
            previousTr.style.background = '';
            tr.style.background = '#413f5e';
         }
      } else if (tr.style.background !== '') {
         tr.style.background = '';
      }
   });
}
