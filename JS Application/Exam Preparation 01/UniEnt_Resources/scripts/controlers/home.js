import { getAllEvents } from '../firebase_models/firebase_data.js';

export default async function () {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs')
    }

    const context = {
        isLoggedIn: localStorage.getItem('isLoggedIn'),
        email: localStorage.getItem('email'),
        events: []
    }

    const resonse = await getAllEvents();
    resonse.docs.forEach(event => {
        const result = {
            id: event.id,
            ...event.data()
        }
        context.events.push(result);
    });

    this.partial('./templates/domain/home.hbs', context);
}