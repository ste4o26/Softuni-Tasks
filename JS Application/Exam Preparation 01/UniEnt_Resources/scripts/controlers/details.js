import { getById } from '../firebase_models/firebase_data.js';

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

    this.partial('./templates/domain/details.hbs', context);
}