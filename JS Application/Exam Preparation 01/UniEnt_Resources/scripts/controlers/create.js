import { createEvent } from '../firebase_models/firebase_data.js'

export default async function () {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs')
    }

    const context = {
        email: localStorage.getItem('email'),
        isLoggedIn: localStorage.getItem('isLoggedIn')
    }

    this.partial('./templates/domain/create.hbs', context);
}

export async function create() {
    if (this.params.name === '' || this.params.dateTime === '' || this.params.description === '' || this.params.imageUrl === '') {
        alert('All fields are required!');
        return;
    }

    const event = {
        name: this.params.name,
        dateTime: this.params.dateTime,
        description: this.params.description,
        imageUrl: this.params.imageUrl,
        organizer: localStorage.getItem('email'),
        peopleInterestedIn: 0
    }

    const response = await createEvent(event);

    alert(`You have successfully created an ivent with name: ${event.name}`);
    this.redirect('#/home');
}