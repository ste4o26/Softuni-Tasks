class Company {
    constructor() {
        this.departments = [];
    }

    addEmployee(username, salary, position, department) {
        if (username.trim() === '' || salary < 0 || position.trim() === '' || department.trim() === '') throw new Error("Invalid input!");
        if (username === null || salary === null || position === null || department === null) throw new Error("Invalid input!");

        const employee = {
            username: username,
            salary: salary,
            position: position,
            department: department
        }

        this.departments.push(employee);
        return `New employee is hired. Name: ${username}. Position: ${position}`;
    }

    bestDepartment() {
        const departmentsMap = this.departments.reduce((acc, emp) => {
            if (acc[emp.department] === undefined) acc[emp.department] = []
            acc[emp.department].push(emp.salary);
            return acc;
        }, {});

        const departmentsSalariesMap = {};
        for (const key in departmentsMap) {
            const currentDepartmentAverageSallary = departmentsMap[key].reduce((a, b) => a + b, 0) / departmentsMap[key].length;
            departmentsSalariesMap[key] = currentDepartmentAverageSallary;
        }

        let bestDepartment = '';
        let bestSalary = 0;
        for (const key of Object.keys(departmentsSalariesMap)) {
            if (bestSalary < departmentsSalariesMap[key]) {
                bestSalary = departmentsSalariesMap[key];
                bestDepartment = key;
            }
        }

        let result = `Best Department is: ${bestDepartment}\nAverage salary: ${bestSalary.toFixed(2)}\n`;
        this.departments
            .filter(emp => emp.department === bestDepartment)
            .sort((f, s) => s.salary - f.salary)
            .forEach(emp => result = result.concat(`${emp.username} ${emp.salary} ${emp.position}\n`));

        return result.trim();
    }
}

let c = new Company();
c.addEmployee("Stanimir", 2000, "engineer", "Construction");
c.addEmployee("Pesho", 1500, "electrical engineer", "Construction");
c.addEmployee("Slavi", 500, "dyer", "Construction");
c.addEmployee("Stan", 2000, "architect", "Construction");
c.addEmployee("Stanimir", 1200, "digital marketing manager", "Marketing");
c.addEmployee("Pesho", 1000, "graphical designer", "Marketing");
c.addEmployee("Gosho", 1350, "HR", "Human resources");
console.log(c.bestDepartment());