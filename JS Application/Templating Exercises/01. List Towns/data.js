export function fetchTownsData() {
    const data = document.getElementById('towns').value;

    if (data.trim() === '') { throw new Error('There is no data to be displayed!') }

    return data.split(', ')
        .reduce((acc, town) => {
            acc.push({ townName: town });
            return acc;
        }, []);
}

export async function fetchTemplates() {
    const response = Promise.all([
        await fetch('./templates/town-template.hbs'),
        await fetch('./templates/all-towns-template.hbs')
    ]);

    const data = Promise.all((await response).map(res => res.text()));
    return data;
}