export function renderTableRow(data) {
    const row = document.createElement('tr');
    data.forEach(item => {
        const td = document.createElement('td');
        td.textContent = item;
        row.appendChild(td);
    });

    const td = document.createElement('td');

    const editBtn = document.createElement('button');
    editBtn.textContent = 'Edit';
    td.appendChild(editBtn);

    const deleteBtn = document.createElement('button');
    deleteBtn.textContent = 'Delete';
    td.appendChild(deleteBtn);

    row.appendChild(td);
    return row;
}

export function toggleEditor(target) {
    const table = document.getElementsByTagName('tbody')[0];
    if (target.className === 'toggled') {
        const data = [
            target.children[0].firstElementChild.value,
            target.children[1].firstElementChild.value,
            target.children[2].firstElementChild.value
        ];

        let row = renderTableRow(data);
        row.className = '';
        row.id = target.id;
        table.replaceChild(row, target);
        return row;
    }

    const row = document.createElement('tr');
    Array.from(target.children)
        .map((child, index) => {
            const td = document.createElement('td');
            if (index >= 3) {
                const confirmBtn = document.createElement('button');
                confirmBtn.textContent = 'Confirm';
                td.appendChild(confirmBtn);

                const cancelBtn = document.createElement('button');
                cancelBtn.textContent = 'Cancel';
                td.appendChild(cancelBtn);

                row.appendChild(td);
                return;
            }

            const input = renderInputField('text', child.textContent);
            td.appendChild(input);
            row.appendChild(td);
        });

    row.className = 'toggled';
    row.id = target.id;
    table.replaceChild(row, target);
    return row;
}

function renderInputField(type, value) {
    const input = document.createElement('input');
    input.type = type;
    input.value = value;
    return input;
}