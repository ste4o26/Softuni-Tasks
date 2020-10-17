function attachGradientEvents() {
    let div = document.getElementById('gradient');
    let output = div.parentElement.nextElementSibling;
    //moje da mi se hvurli greshka oshte tuk poneje vurvq po durvoto bez proverki no shvanah ideqta!

    if (div === null || output === null) {
        throw new Error('Something went wrong!');
    }

    div.addEventListener('mousemove', e => {
        let percentage = Math.floor((e.offsetX / e.target.clientWidth) * 100);
        output.textContent = `${percentage}%`;
    });

    div.addEventListener('mouseout', e => output.textContent = '');
}