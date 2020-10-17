function solve() {
    let firstSelector;
    let secondSelector;
    let resultSelector;

    return {
        add() {
            resultSelector.value = Number(firstSelector.value) + Number(secondSelector.value);
        },

        subtract() {
            resultSelector.value = Number(firstSelector.value) - Number(secondSelector.value);
        },

        init(first, second, result) {
            firstSelector = document.querySelector(first);
            secondSelector = document.querySelector(second);
            resultSelector = document.querySelector(result);
        },
    }
}