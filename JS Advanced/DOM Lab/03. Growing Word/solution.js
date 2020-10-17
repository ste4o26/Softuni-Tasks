function growingWord() {
  let paragraph = document.getElementById('exercise').getElementsByTagName('p')[0];

  if (paragraph === null) {
    throw new Error('Any of the elements which you are looking for may not exit!');
  }

  cahngeFontSize(paragraph);
  paragraph.style.color = getNextColor();
  //changeColor(paragraph);
}

const getNextColor = (function () {
  let colorsCounter = 0;
  const colorsMap = ['#5B88BD', '#8FF897', '#A40014'];

  return function () {
    if (colorsCounter >= colorsMap.length) {
      colorsCounter = 0;
    }

    return colorsMap[colorsCounter++];
  }
})();

function cahngeFontSize(paragraph) {
  paragraphFontSize = Number(window.getComputedStyle(paragraph).fontSize.match(/\d+/));
  if (paragraphFontSize === 0) {
    paragraphFontSize++;
  }

  paragraphFontSize *= 2;
  paragraph.style.fontSize = paragraphFontSize + 'px';
}

//judge minava s tova
// function changeColor(paragraph) {
//   let currentColor = paragraph.style.color;
//   switch (currentColor) {
//     case 'blue':
//       currentColor = colorsMap.green;
//       break;

//     case 'green':
//       currentColor = colorsMap.red;
//       break;

//     case 'red':
//       currentColor = colorsMap.blue;
//       break;

//     default:
//       currentColor = colorsMap.blue;
//       break;
//   }

//   paragraph.style.color = currentColor;
// }

