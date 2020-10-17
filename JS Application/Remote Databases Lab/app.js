function solve() {
    const elements = {
        submitBtn: () => document.getElementById('submitBtn'),
        outputDiv: () => document.getElementById('output'),
        logoutBtn: () => document.getElementById('logout'),
        email: () => document.getElementById('email'),
        password: () => document.getElementById('password'),
        container: () => document.getElementById('container')
    };

    elements.logoutBtn().style.display = 'none';

    elements.submitBtn().addEventListener('click', loginUserHandler);
    elements.logoutBtn().addEventListener('click', logoutUserHandler)

    function loginUserHandler(e) {
        e.preventDefault();
        let [email, password] = [elements.email().value, elements.password().value];
        if (email === undefined || email.trim() === '' || password === undefined || password.trim() === undefined) {
            throw new TypeError('You should fill the required fields!')
        }

        firebase.auth()
            .signInWithEmailAndPassword(email, password)
            .catch(function (error) {
                elements.outputDiv().style.color = 'red';
                elements.outputDiv().textContent = `Status code: ${error.code}  -   Error Message: ${error.message}`;
            });

        fetch('https://ste4o-test-app.firebaseio.com/users.json', {
            method: 'POST',
            headers: { 'Content-Type': 'Application.json' },
            body: JSON.stringify({
                email: email,
                password: password
            })
        })
    }

    function logoutUserHandler(e) {
        firebase.auth()
            .signOut()
            .catch(function (error) {
                elements.outputDiv().style.color = 'red';
                elements.outputDiv().textContent = error.message;
            })
    }


    firebase.auth()
        .onAuthStateChanged(function (user) {
            console.log(user);
            elements.outputDiv().style.color = 'black';
            if (user) {
                elements.outputDiv().textContent = `You have been logged in with ${user.email} email.`;
                elements.container().style.display = 'none';
                elements.logoutBtn().style.display = 'block';
            } else {
                elements.outputDiv().textContent = 'You are logged out!';
                elements.container().style.display = 'block';
                elements.logoutBtn().style.display = 'none';
            }
        });
}

solve();