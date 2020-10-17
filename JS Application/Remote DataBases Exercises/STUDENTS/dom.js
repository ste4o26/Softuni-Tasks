let idCounter = 1

export function createRow(student) {
    const row = document.createElement('tr');

    const id = document.createElement('td');
    id.textContent = idCounter;
    row.appendChild(id);
    idCounter++;

    Object.keys(student)
        .map((key, index) => {
            if (index >= 4) { return }
            const td = document.createElement('td');
            td.textContent = student[key];
            row.appendChild(td);
        });
    return row;
}

export function toggleLoader() {
    const loader = document.getElementById('loader');
    loader.style.display === 'block' ?
        loader.style.display = 'none' :
        loader.style.display = 'block';
}