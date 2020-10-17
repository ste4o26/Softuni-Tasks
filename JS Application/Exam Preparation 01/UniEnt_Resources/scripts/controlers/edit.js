import { getById, editEvent } from '../firebase_models/firebase_data.js';

export default async function () {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs')
    }



    const response = await getById(this.params.id);
    const context = {
        isLoggedIn: localStorage.getItem('isLoggedIn'),
        email: localStorage.getItem('email'),
        isOrganizer: response.data().organizer === localStorage.getItem('email'),
        id: response.id,
        ...response.data()
    }

    if (!context.isOrganizer) {
        alert('You can not edit an event that you have not created!');
        this.redirect('#/home');
        return;
    }

    this.partial('./templates/domain/edit.hbs', context);
}

export async function edit() {
    if (this.params.name === '' || this.params.dateTime === '' || this.params.description === '' || this.params.imageUrl === '') {
        alert('All fields are required!');
        return;
    }

    const event = {
        name: this.params.name,
        dateTime: this.params.dateTime,
        description: this.params.description,
        imageUrl: this.params.imageUrl
    }


    const response = await editEvent(this.params.id, event);
    console.log(response);

    this.redirect(`#/details/${this.params.id}`);
}