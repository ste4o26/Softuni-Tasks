import { throwErrorIfBadRequest, getTrekById, editTrek } from "../data.js";

export default async function () {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs')
    }

    let result;
    try {
        result = await getTrekById(this.params.id);
        throwErrorIfBadRequest(result)
    } catch (error) {
        alert(error.message);
        this.redirect('#/home');
        return;
    }

    const context = {
        username: localStorage.getItem('username'),
        isLoggedIn: localStorage.getItem('isLoggedIn'),
        userId: localStorage.getItem('userId'),
    };

    Object.assign(context, result);
    if (result.ownerId === localStorage.getItem('userId')) { Object.assign(context, { isOrganizer: true }) }
    this.partial('./templates/domain/details.hbs', context);
}


export async function like() {
    let result;
    try {
        result = await getTrekById(this.params.id);
        throwErrorIfBadRequest(result);
        result.likes++;

        result = await editTrek(result);
        throwErrorIfBadRequest(result);
    } catch (error) {
        alert(error.message);
        this.redirect('#/home');
        return;
    }

    alert(`You liked ${result.location} trek!`);
    this.redirect(`#/details/${result.objectId}`);
}