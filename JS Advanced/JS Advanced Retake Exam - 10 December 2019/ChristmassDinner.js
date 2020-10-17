class ChristmasDinner {
    budget;
    dishes;
    products;
    guests;

    constructor(budget) {
        if (budget < 0) { throw new Error('The budget cannot be a negative number') }
        this.budget = budget;
        this.dishes = [];
        this.products = [];
        this.guests = {};
    }

    shopping(product) {
        let [name, price] = product;
        if (this.budget - price < 0) { throw new Error('Not enough money to buy this product') }
        this.products.push(name);
        this.budget -= price;
        return `You have successfully bought ${name} !`;
    }

    recipes(recipe) {
        let hasAllProducts = recipe.productsList.every(item => this.products.includes(item));
        if (!hasAllProducts) { throw new Error('We do not have this product') }

        this.dishes.push(recipe);
        return `${recipe.recipeName} has been successfully cooked!`;
    }

    inviteGuests(guestName, dishName) {
        let dish = this.dishes.find(item => item.recipeName === dishName);
        if (dish === undefined) { throw new Error('We do not have this dish') }
        if (this.guests[guestName] !== undefined) { throw new Error('This guest has already been invited') }
        this.guests[guestName] = dishName;
        return `You have successfully invited ${guestName}!`;
    }

    showAttendance() {
        return Object.entries(this.guests)
            .reduce((acc, guest) => {
                let [guestName, guestDish] = guest;
                let products = this.dishes.find(dish => dish.recipeName === guestDish);
                return acc.concat(`${guestName} will eat ${guestDish}, which consists of ${products.productsList.join(', ')}\n`);
            }, ``)
            .trim();
    }
}

let dinner = new ChristmasDinner(300);

dinner.shopping(['Salt', 1]);
dinner.shopping(['Beans', 3]);
dinner.shopping(['Cabbage', 4]);
dinner.shopping(['Rice', 2]);
dinner.shopping(['Savory', 1]);
dinner.shopping(['Peppers', 1]);
dinner.shopping(['Fruits', 40]);
dinner.shopping(['Honey', 10]);

dinner.recipes({
    recipeName: 'Oshav',
    productsList: ['Fruits', 'Honey']
});

dinner.recipes({
    recipeName: 'Folded cabbage leaves filled with rice',
    productsList: ['Cabbage', 'Rice', 'Salt', 'Savory']
});

dinner.recipes({
    recipeName: 'Peppers filled with beans',
    productsList: ['Beans', 'Peppers', 'Salt']
});

dinner.inviteGuests('Ivan', 'Oshav');
dinner.inviteGuests('Petar', 'Folded cabbage leaves filled with rice');
dinner.inviteGuests('Georgi', 'Peppers filled with beans');

console.log(dinner.showAttendance()); 