export async function fetchTemplates() {
    const response = Promise.all([
        await fetch('./templates/monkey-template.hbs'),
        await fetch('./templates/all-monkeys-template.hbs')
    ]);

    const data = Promise.all((await response).map(res => res.text()));
    return data;
}