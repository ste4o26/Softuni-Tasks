import { getAllTreks, throwErrorIfBadRequest } from "../data.js";
export default async function () {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        trek: await this.load('./templates/domain/trek.hbs'),
        footer: await this.load('./templates/common/footer.hbs')
    }

    const context = {
        username: localStorage.getItem('username'),
        isLoggedIn: localStorage.getItem('isLoggedIn'),
        userId: localStorage.getItem('userId'),
        treks: []
    };

    if (context.isLoggedIn === null) {
        this.partial('./templates/domain/home.hbs');
        return;
    }

    let result;
    try {
        result = await getAllTreks();
        throwErrorIfBadRequest(result);
    } catch (error) {
        alert(error.message);
        return;
    }

    context.treks = result;
    this.partial('./templates/domain/home.hbs', context);
}

