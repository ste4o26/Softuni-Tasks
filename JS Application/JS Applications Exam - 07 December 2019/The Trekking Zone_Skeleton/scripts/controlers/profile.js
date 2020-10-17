import { throwErrorIfBadRequest, getAllTreks } from "../data.js";

export default async function () {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs')
    }

    let result;
    try {
        result = await getAllTreks();
        throwErrorIfBadRequest(result);
    } catch (error) {
        alert(error.message);
        this.redirect('#/home');
        return;
    }

    const context = {
        username: localStorage.getItem('username'),
        isLoggedIn: localStorage.getItem('isLoggedIn'),
        wishedTreks: [],
        wishedTreksCount: 0
    }


    context.wishedTreks = result
        .filter(trek => trek.ownerId === this.params.id)
        .map(trek => trek.location);

    context.wishedTreksCount = context.wishedTreks.length;
    this.partial('./templates/user/profile.hbs', context);
}