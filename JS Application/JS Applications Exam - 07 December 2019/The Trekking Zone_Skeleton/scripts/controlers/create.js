import { createTrek, throwErrorIfBadRequest } from '../data.js'
export default async function () {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs')
    }

    const context = {
        username: localStorage.getItem('username'),
        isLoggedIn: localStorage.getItem('isLoggedIn'),
        userId: localStorage.getItem('userId'),
    };

    this.partial('./templates/domain/create.hbs', context);
}

export async function create() {
    const areFieldsFilled = Object.keys(this.params)
        .filter(key => this.params[key] === '')
        .length === 0

    if (!areFieldsFilled) {
        alert('All fields are required!');
        return;
    }

    const trek = {
        location: this.params.location,
        imageUrl: this.params.imageUrl,
        description: this.params.description,
        departureDate: this.params.departureDate,
        organizer: localStorage.getItem('username')
    }

    console.log(trek);
    let result;
    try {
        result = await createTrek(trek);
        throwErrorIfBadRequest(result);
    } catch (error) {
        alert(error.message);
        this.redirect('#/create');
        return;
    }

    alert(`Successfully created trek with location: ${result.location}`);
    this.redirect('#/home');
}