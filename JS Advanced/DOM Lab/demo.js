let myDiv = document.getElementsByTagName('div')[0];
myDiv.innerHTML = '<strong>Hello Web Js<//strong>';

let paragraph = document.createElement('p');
paragraph.textContent = 'Hello i am new Paragraph which stays at top of the element!';
myDiv.prepend(paragraph);

let anotherParagraph = document.createElement('p');
anotherParagraph.textContent = 'Hello i am new Paragraphx which stays at the bottom of the element!';
myDiv.appendChild(anotherParagraph);

let firstParagraph = document.getElementsByTagName('p')[0];
firstParagraph.remove();