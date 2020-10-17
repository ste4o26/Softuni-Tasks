import { getAllEvents } from '../firebase_models/firebase_data.js';
export default async function () {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs')
    }

    const context = {
        isLoggedIn: localStorage.getItem('isLoggedIn'),
        email: localStorage.getItem('email')
    }

    const response = await getAllEvents();
    context.ownEvents = response.docs
        .filter(event => event.data().organizer === localStorage.getItem('email'))
        .reduce((acc, event) => {
            acc.push({ name: event.data().name });
            return acc;
        }, []);

    context.organizedEvents = context.ownEvents.length;

    this.partial('./templates/user/profile.hbs', context);
}