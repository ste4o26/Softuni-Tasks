function solve() {
    const juinorTasks = [` is working on a simple task.`];

    const managerTasks = [
        ` scheduled a meeting.`,
        ` is preparing a quarterly report.`];

    const seniorTasks = [
        ` is working on a complicated task.`,
        ` is taking time off work.`,
        ` is supervising junior workers.`];


    class Employee {
        constructor(name, age) {
            if (new.target === Employee) { throw new Error('Cannot instantiate directly') }
            this.name = name;
            this.age = age;
            this.salary = 0;
            this.tasks = [];
        }

        getSalary() {
            return this.salary;
        }

        work() {
            let task = this.tasks.shift();
            console.log(this.name + task)
            this.tasks.push(task);
        }

        collectSalary() {
            console.log(`${this.name} received ${this.getSalary()} this month.`);
        }
    }

    class Junior extends Employee {
        constructor(name, age) {
            super(name, age);
            juinorTasks.forEach(task => this.tasks.push(task));
        }
    }

    class Manager extends Employee {
        constructor(name, age) {
            super(name, age);
            this.dividend = 0;
            managerTasks.forEach(task => this.tasks.push(task));
        }

        getSalary() {
            return this.salary + this.dividend;
        }
    }

    class Senior extends Employee {
        constructor(name, age) {
            super(name, age);
            seniorTasks.forEach(task => this.tasks.push(task));
        }
    }

    return {
        Employee,
        Junior,
        Senior,
        Manager
    }
}

let result = solve();
let guy1 = new result.Junior('Peter', 27);
guy1.salary = 1200;
console.log(guy1.collectSalary());