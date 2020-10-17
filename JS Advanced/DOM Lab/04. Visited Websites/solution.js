function solve() {
  //za da mine v softuni trqbva da premahna spana i da rabotq direktno varhu teksta
  //event obekta avtomatichnose podava na funkciqta kato parametar!!!
  document
    .getElementsByClassName('middled')[0]
    .addEventListener('click', updateVisitings);
}

const updateVisitings = (function () {
  const websites = {
    Wikipedia: 4,
    Google: 2,
    Gmail: 7,
    YouTube: 4,
    stackoverflow: 6,
    SoftUni: 1
  };

  return function (event) {
    let link = event.target;//.parentElement; ako iskam da raboti taka trqbva da dobavq spanovete v HTML
    let paragraph = link.nextElementSibling;
    if (link === undefined || paragraph === undefined) {
      throw new Error('Something went wrong !');
    }

    //filter by class name not node name -> now its by node name becouse in the given HTML there isnt class atribute on a tags!!!!
    if (link.nodeName === 'A') {
      let websiteName = link.textContent.trim();
      paragraph.textContent = `visited ${++websites[websiteName]} times`;;
    }

    event.stopPropagation();
  }
})();