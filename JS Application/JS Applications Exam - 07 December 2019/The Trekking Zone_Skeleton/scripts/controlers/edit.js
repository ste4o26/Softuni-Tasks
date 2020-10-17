import { editTrek, throwErrorIfBadRequest, getTrekById } from '../data.js';

export default async function () {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs')
    }

    try {
        let result = await getTrekById(this.params.id);
        throwErrorIfBadRequest(result);

        const context = {
            username: localStorage.getItem('username'),
            isLoggedIn: localStorage.getItem('isLoggedIn'),
            userId: localStorage.getItem('userId'),
        }
        
        Object.assign(context, result)

        this.partial('./templates/domain/edit.hbs', context);
    } catch (error) {
        alert(error.message);
        this.redirect(`#/details/${result.objectId}`);
    }
}

export async function edit() {
    const confirmation = confirm('Are you sure you want to edit this trek?');
    if (confirmation === false) {
        this.redirect(`#/details/${this.params.id}`);
        return;
    }

    let result;
    try {
        const trek = {
            objectId: this.params.id,
            location: this.params.location,
            imageUrl: this.params.imageUrl,
            description: this.params.description,
            departureDate: this.params.departureDate,
        }

        result = await editTrek(trek);
        throwErrorIfBadRequest(result);
    } catch (error) {
        alert(error.message);
        this.redirect(`#/details/${this.params.id}`);
        return;
    }

    alert(`You successfully edited trek with location: ${result.location}`);
    this.redirect(`#/details/${result.objectId}`);
}