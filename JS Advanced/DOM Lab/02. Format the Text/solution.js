function solve() {
  let inputParagraph = document.getElementById('input');
  let outputDiv = document.getElementById('output');

  if (outputDiv === null || inputParagraph === null) {
    throw new Error('Some of elements which you need do not exist!');
  }

  const sentences = inputParagraph.textContent.split('.');


  for (let i = 0; i < sentences.length - 1; i += 3) {
    let paragraph = document.createElement('p');

    for (let j = 0; j < 3; j++) {
      if (sentences[i + j] !== undefined) {
        paragraph.textContent += sentences[i + j];
      }
    }

    outputDiv.appendChild(paragraph);
  }
}

document.getElementById('formatItBtn').addEventListener('click', solve);