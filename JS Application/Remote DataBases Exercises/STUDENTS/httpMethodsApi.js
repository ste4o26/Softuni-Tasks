const appId = '1C7B7EFD-E786-40F0-FF34-2B058351BD00';
const apiKey = '7688E6B3-201F-4DE9-B1D3-6A9F47223EBB';

function getHost(endPoint) {
    return `https://api.backendless.com/${appId}/${apiKey}/data/${endPoint}`;
}

export async function fetchAllStudents() {
    const response = await fetch(getHost('Students'));
    if (response.status >= 400) { throw new Error(`Status code: ${response.status}  -  Message: ${response.statusText}`) }
    const data = await response.json();
    if (data === undefined || data === null) { throw new TypeError('There is no data! Create some records first!') }
    return data;
}

export async function createStudent(student) {
    const response = await fetch(getHost('Students'), {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(student)
    });
    if (response.status >= 400) { throw new Error(`Status code: ${response.status}  -  Message: ${response.statusText}`) }
    const data = await response.json();
    return data;
}