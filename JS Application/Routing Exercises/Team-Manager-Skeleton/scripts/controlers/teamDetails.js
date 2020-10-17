import { getTeamById } from '../data.js';

export default async function (context) {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs'),
        teamMember: await this.load('./templates/catalog/teamMember.hbs'),
        teamControls: await this.load('./templates/catalog/teamControls.hbs')
    }

    //TODO Members
    const data = await getTeamById(this.params.id);
    Object.assign(data, this.app.userData)
    console.log(data);

    if (data.ownerId === this.app.userData.userId) { data.isAuthor = true }
    if (data.objectId === this.app.userData.teamId) {
        data.hasTeam = true;    
        console.log(data.isOnTeam);
    }

    this.partial('./templates/catalog/details.hbs', data);
}