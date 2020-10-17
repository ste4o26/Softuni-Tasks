function solve(input, criteria) {
    const tokens = criteria.split(/-/gim);
    data = JSON.parse(input);

    let filteredEmployees = data.filter(employee => employee[tokens[0]] === tokens[1]);

    let result = '';
    for (let i = 0; i < filteredEmployees.length; i++) {
        const employee = filteredEmployees[i];
        result += `${i}. ${employee.first_name} ${employee.last_name} - ${employee.email}\n`;
    }
    return result.trim();
}


console.log(
    solve(`[{
        "id": "1",
        "first_name": "Ardine",
        "last_name": "Bassam",
        "email": "abassam0@cnn.com",
        "gender": "Female"
    },
    {
        "id": "2",
        "first_name": "Kizzee",
        "last_name": "Jost",
        "email": "kjost1@forbes.com",
        "gender": "Female"
    },
    {
        "id": "3",
        "first_name": "Evanne",
        "last_name": "Maldin",
        "email": "emaldin2@hostgator.com",
        "gender": "Male"
    }]`,
        'gender-Female')
);

console.log(
    solve(`[{ 
        "id": "1", 
        "first_name": "Kaylee", 
        "last_name": "Johnson", 
        "email": "k0@cnn.com", 
        "gender": "Female" 
    }, { 
        "id": "2", 
        "first_name": "Kizzee", 
        "last_name": "Johnson", 
        "email": "kjost1@forbes.com", 
        "gender": "Female" 
    }, { 
        "id": "3", 
        "first_name": "Evanne", 
        "last_name": "Maldin", 
        "email": "emaldin2@hostgator.com", 
        "gender": "Male" 
    }, { 
        "id": "4", 
        "first_name": "Evanne", 
        "last_name": "Johnson", 
        "email": "ev2@hostgator.com", 
        "gender": "Male" 
    }]`,
        'all')
);