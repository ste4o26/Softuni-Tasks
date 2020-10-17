function init() {
    // Your web app's Firebase configuration
    var firebaseConfig = {
        apiKey: "AIzaSyC9Bc6PCmPWw-YM7M1QhLPAuDMcJHg5lsg",
        authDomain: "ste4o-test-app.firebaseapp.com",
        databaseURL: "https://ste4o-test-app.firebaseio.com",
        projectId: "ste4o-test-app",
        storageBucket: "ste4o-test-app.appspot.com",
        messagingSenderId: "688147384723",
        appId: "1:688147384723:web:1323eadbb90ce7d0888066",
        measurementId: "G-9VTVTN6DN7"
    };
    // Initialize Firebase
    firebase.initializeApp(firebaseConfig);
    firebase.analytics();
}

init();