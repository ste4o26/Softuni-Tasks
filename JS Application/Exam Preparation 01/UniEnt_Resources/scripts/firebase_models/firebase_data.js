const collectionName = 'events';

export function getById(id) {
    const result = firebase.firestore().collection(`${collectionName}`).doc(id).get();
    return result;
}

export function getAllEvents() {
    const result = firebase.firestore().collection(`${collectionName}`).get();
    return result;
}

export function createEvent(data) {
    const result = firebase.firestore().collection(`${collectionName}`).add(data);
    return result;
}

export function editEvent(id, data) {
    const result = firebase.firestore().collection(`${collectionName}`).doc(id).update(data);
    return result;
}

export function deleteEventPost(id) {
    const result = firebase.firestore().collection(`${collectionName}`).doc(id).delete()
    return result;
}