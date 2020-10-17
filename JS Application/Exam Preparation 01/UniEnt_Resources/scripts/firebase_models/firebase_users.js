export function registerUser(email, password) {
    return firebase.auth().createUserWithEmailAndPassword(email, password);
}

export function loginUser(email, password) {
    return firebase.auth().signInWithEmailAndPassword(email, password);
}

export function logoutUser() {
    return firebase.auth().signOut();
}