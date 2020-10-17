function solve(input) {
    // pravq modulno delene na duljinata na masiva poneje inache shte trqbva da go vurtq mnogo povheche puti
    let n = Number(input.pop()) % input.length;
    return input
        .reduce((a, _) =>{
            if (n-- > 0){
                a.unshift(a.pop());
            }
            return a;
        } ,[...input])
        .join(' ');

    // for (let i = 0; i < n; i++) {
    //     let removedItem = input.pop()
    //     input.unshift(removedItem);
    // }
    // return input.join(' ');
}


console.log(
    solve(['1', '2', '3', '4', '2'])
)

console.log(
    solve(['Banana', 'Orange', 'Coconut', 'Apple', '15'])
);