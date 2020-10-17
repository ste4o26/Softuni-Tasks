function validate() {
    let regex = new RegExp(/([a-z]+)@([a-z]+)\.([a-z]+)/);
    let input = document.getElementById('email');

    input.addEventListener('change', e => {
        let email = e.target.value;
        regex.test(email) ? e.target.className = '' : e.target.className = 'error';
    });
}