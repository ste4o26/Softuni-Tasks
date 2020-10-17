import * as dom from './dom.js';
import * as api from './httpMethodsApi.js';

window.addEventListener('load', solve);

async function solve(e) {
    const createBtn = document.getElementById('crete-student');
    try {
        createBtn.addEventListener('click', registerStudent);
    } catch (err) {
        console.error(err.message);
    }
    await dsiplayAllStudents();
}


async function dsiplayAllStudents() {
    const table = document.querySelector('#results tbody');
    table.innerHTML = '';
    dom.toggleLoader();

    let students;
    try {
        students = await api.fetchAllStudents();
    } catch (err) {
        console.error(err.message);
    }

    dom.toggleLoader();

    students.sort((f, s) => f - s)
        .forEach(student => {
            const row = dom.createRow(student);
            table.appendChild(row);
        });
}

async function registerStudent(e) {
    e.preventDefault();
    const data = document.querySelectorAll('input');

    if (data[0].value === '' || data[1].value === '' || data[2].value === '' || data[3].value === '') {
        throw new Error('All fields are require!');
    }

    const student = {
        firstName: data[0].value,
        lastName: data[1].value,
        facultyNumber: Number(data[2].value),
        grade: Number(data[3].value)
    }

    try {
        await api.createStudent(student);
    } catch (err) {
        console.error(err.message);
    }

    await dsiplayAllStudents();
}