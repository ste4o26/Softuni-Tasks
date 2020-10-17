function focus() {
    let outerDiv = document.getElementsByTagName('div')[0];
    if (outerDiv === null) {
        throw new Error('Somenthing went wrong!');
    }
    
    outerDiv.addEventListener('focus', e => {
        e.preventDefault();
        e.target.parentElement.focus();
        e.target.parentElement.className = 'focused';
        e.target.parentElement.style.color = 'pink';
    });

    outerDiv.addEventListener('blur', e => {
        e.preventDefault();
        e.target.parentElement.blur();
        e.target.parentElement.className = '';
    });
}


//tova raboti pri men a gorniq primer raboti navsqkude osven pri men
    // outerDiv.addEventListener('click', e => handler(e, outerDiv));

    // function handler(e, outerDiv) {
    //     e.preventDefault();
    //     let innerDiv = outerDiv.firstElementChild;
    //     let t = e.target;

    //     while (innerDiv !== null && t !== null) {
    //         let currentTitle = innerDiv.firstElementChild.textContent;
    //         let targetTitle = t.previousElementSibling.textContent;

    //         if (innerDiv.className === 'focused') {
    //             innerDiv.blur();
    //             innerDiv.classList.remove('focused');
    //         }

    //         if (t.nodeName === 'INPUT' && targetTitle === currentTitle) {
    //             innerDiv.focus();
    //             innerDiv.className = 'focused';
    //         }
    //         innerDiv = innerDiv.nextElementSibling;
    //     }
    // }

