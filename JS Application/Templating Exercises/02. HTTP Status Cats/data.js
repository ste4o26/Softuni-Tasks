export async function fetchTemplates() {
    const response = Promise.all([
        await fetch('./templates/cat-template.hbs'),
        await fetch('./templates/all-cats-template.hbs')
    ]);

    const data = Promise.all((await response).map(res => res.text()));
    return data;
}