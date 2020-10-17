function loadRepos() {
   const url = 'https://api.github.com/users/testnakov/repos';
   const outputDiv = document.querySelector('#res');

   if (outputDiv === null) {
      throw new TypeError('Something went wrong!');
   }

   const httpRequest = new XMLHttpRequest();
   httpRequest.addEventListener('readystatechange', e => {
      if (httpRequest.readyState == 4 && httpRequest.status == 200) {
         //JSON.parse(httpRequest.responseText) => parsva responsa kato jason ako moje
         console.log(JSON.parse(httpRequest.responseText));
         outputDiv.textContent = httpRequest.responseText;
      }
   });

   httpRequest.open('GET', url);
   httpRequest.send();

   //dolnoto e ekvivalent na gornoto no po stariq nachin!
   // fetch(url)
   //    .then(item => item.json())
   //    .then(data =>  outputDiv.textContent += JSON.stringify(data));

}