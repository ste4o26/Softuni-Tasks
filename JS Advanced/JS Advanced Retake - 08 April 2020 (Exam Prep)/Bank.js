class Bank {
    #bankName;

    constructor(bankName) {
        this.#bankName = bankName;
        this.allCustomers = [];
    }

    newCustomer(customer) {
        if (this.isExistingCustomer(customer.personalId)) { throw new Error(`${customer.firstName} ${customer.lastName} is already our customer!`) }
        this.allCustomers.push(customer);
        return customer;
    }

    isExistingCustomer(personalId) {
        return this.allCustomers.find(customer => customer.personalId === personalId) !== undefined ? true : false;
    }

    depositMoney(personalId, amount) {
        if (!this.isExistingCustomer(personalId)) { throw new Error('We have no customer with this ID!') }
        let customer = this.allCustomers.find(customer => customer.personalId === personalId);

        if (customer.totalMoney === undefined) { customer.totalMoney = 0 }
        if (customer.transactions === undefined) { customer.transactions = [] }

        customer.totalMoney += amount;
        customer.transactions.push(`${customer.firstName} ${customer.lastName} made deposit of ${amount}$!`)

        return `${customer.totalMoney}$`;
    }

    withdrawMoney(personalId, amount) {
        if (!this.isExistingCustomer(personalId)) { throw new Error('We have no customer with this ID!') }
        let customer = this.allCustomers.find(customer => customer.personalId === personalId);

        if (customer.totalMoney === undefined || customer.totalMoney < amount) { throw new Error(`${customer.firstName} ${customer.lastName} does not have enough money to withdraw that amount!`) }

        customer.totalMoney -= amount;
        if (customer.transactions === undefined) { customer.transactions = [] }
        customer.transactions.push(`${customer.firstName} ${customer.lastName} withdrew ${amount}$!`)

        return `${customer.totalMoney}$`;
    }

    customerInfo(personalId) {
        if (!this.isExistingCustomer(personalId)) { throw new Error('We have no customer with this ID!') }

        let customer = this.allCustomers.find(customer => customer.personalId === personalId);
        let result = `Bank name: ${this.#bankName}\nCustomer name: ${customer.firstName} ${customer.lastName}\nCustomer ID: ${customer.personalId}\nTotal Money: ${customer.totalMoney}$\nTransactions:\n`;

        return customer.transactions
            .reduceRight((acc, transaction, index) => acc = acc.concat(`${index + 1}. ${transaction}\n`), result)
            .trim();
    }
}

let bank = new Bank('SoftUni Bank');

console.log(bank.newCustomer({ firstName: 'Svetlin', lastName: 'Nakov', personalId: 6233267 }));
console.log(bank.newCustomer({ firstName: 'Mihaela', lastName: 'Mileva', personalId: 4151596 }));

bank.depositMoney(6233267, 250);
console.log(bank.depositMoney(6233267, 250));
bank.depositMoney(4151596, 555);

console.log(bank.withdrawMoney(6233267, 125));

console.log(bank.customerInfo(6233267));


