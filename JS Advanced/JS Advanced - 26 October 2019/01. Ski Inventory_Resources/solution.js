function solve() {
   const addButton = document.querySelector('#add-new button');
   const filterButton = document.querySelector('.filter button');
   const buyButton = document.querySelector('#myProducts button');
   let totalPrice = 0;

   if (addButton === null || filterButton === null || buyButton === null) {
      throw new TypeError('Something went wrong!!!');
   }

   addButton.addEventListener('click', addProduct);
   filterButton.addEventListener('click', filterAvailableProducts);
   buyButton.addEventListener('click', buyProducts);

   function addProduct(e) {
      e.preventDefault();

      const [name, quantity, price] = document.querySelectorAll('#add-new input');

      const span = document.createElement('span');
      span.textContent = name.value;

      const strong = document.createElement('strong');
      strong.textContent = `Available: ${quantity.value}`;

      const divStrong = document.createElement('strong');
      divStrong.textContent = price.value;

      const button = document.createElement('button');
      button.textContent = `Add to Client's List`;
      button.addEventListener('click', addToMyProducts);

      const div = document.createElement('div');
      div.appendChild(divStrong);
      div.appendChild(button);

      const li = document.createElement('li');
      li.appendChild(span);
      li.appendChild(strong);
      li.appendChild(div);

      const ul = document.querySelector('#products ul');
      ul.appendChild(li);
   }

   function filterAvailableProducts(e) {
      const keyWords = document.querySelector('#filter').value.toLowerCase();
      const availableProducts = document.querySelectorAll('#products ul li');

      Array.from(availableProducts).map(item => {
         let isIncludesKeyword = item.querySelector('span').textContent.toLowerCase().includes(keyWords);
         if (isIncludesKeyword) {
            item.style.display = 'block';
         } else {
            item.style.display = 'none';
         }
      });
   }

   function addToMyProducts(e) {
      let itemName = this.parentElement.parentElement.querySelector('span').textContent;
      let itemQuantity = this.parentElement.parentElement.querySelector('strong').textContent.match(/\d+/);
      let itemPrice = Number(this.parentElement.querySelector('strong').textContent);

      if (itemQuantity > 0) {
         totalPrice += itemPrice
         const h1 = document.querySelectorAll('h1')[1];
         h1.textContent = `Total Price: ${(totalPrice).toFixed(2)}`;

         const strong = document.createElement('strong');
         strong.textContent = itemPrice.toFixed(2);

         const li = document.createElement('li');
         li.textContent = itemName;
         li.appendChild(strong);

         const ul = document.querySelector('#myProducts ul');
         ul.appendChild(li);

         itemQuantity--;
         this.parentElement.parentElement.querySelector('strong').textContent = `Available: ${itemQuantity}`;
      }

      if (itemQuantity <= 0) {
         this.parentElement.parentElement.remove();
      }
   }

   function buyProducts(e) {
      const ul = document.querySelector('#myProducts ul');
      const h1 = document.querySelectorAll('h1')[1];

      ul.innerHTML = '';
      h1.textContent = 'Total Price: 0.00';
      totalPrice = 0;
   }
}

