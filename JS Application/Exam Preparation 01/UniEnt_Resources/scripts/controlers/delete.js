import { deleteEventPost } from '../firebase_models/firebase_data.js'
export default async function () {
    const response = await deleteEventPost(this.params.id);
    this.redirect('#/home');
}