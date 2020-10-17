import { editEvent, getById } from '../firebase_models/firebase_data.js'
export default async function () {
    const response = await getById(this.params.id);
    
    await editEvent(this.params.id, { peopleInterestedIn: response.data().peopleInterestedIn + 1 });
    this.redirect(`#/details/${this.params.id}`);
}