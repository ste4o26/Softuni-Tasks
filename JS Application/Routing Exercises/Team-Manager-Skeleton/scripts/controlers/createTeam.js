import { createTeamPost } from '../data.js';

export default async function (context) {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs'),
        createForm: await this.load('./templates/create/createForm.hbs')
    }

    this.partial('./templates/create/createPage.hbs');
}

export async function createTeam(context) {
    if (this.params.name.trim() === '' || this.params.comment.trim() === '') {
        alert('All fields are required!');
        return;
    }

    try {
        const result = await createTeamPost(this.params.name, this.params.comment);
        console.log(result);
        console.log(result.ownerId, localStorage.getItem('userId'));
        console.log(result.ownerId === localStorage.getItem('userId'));
        if (result.hasOwnProperty('errorData')) {
            const error = new Error();
            Object.assign(error, result);
            throw error;
        }


        this.app.userData.teamId = result.objectId;
        this.app.userData.isAuthor = true;
        this.app.userData.isOnTeam = true;



        this.redirect(`#/catalog/${result.objectId}`);
    } catch (error) {
        alert(error.message);
    }

}