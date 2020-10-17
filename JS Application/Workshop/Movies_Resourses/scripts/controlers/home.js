import { isLoggedIn } from '../data.js';

export default async function () {
    isLoggedIn(this);

    this.partials = {
        navigation: await this.load('./templates/common/navigation.hbs'),
        footer: await this.load('./templates/common/footer.hbs'),
    };


    this.partial('./templates/movies/home.hbs', this.app.userData);
}