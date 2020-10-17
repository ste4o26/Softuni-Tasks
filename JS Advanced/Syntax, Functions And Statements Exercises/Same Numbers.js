function solve(number) {
    const data = number
        .toString()
        .split('');


    const areAllSame = data
        .filter(item => +item === +data[0])
        .length === data.length;

    console.log(areAllSame);

    //imperativniq nachin!
    // for (let i = 0; i < data.length; i++) {
    //     if (data[0] !== data[i]) {
    //         areAllSame = false;
    //         break;
    //     }
    // }
    // console.log(areAllSame);

    return data.reduce((accumolator, item) => +accumolator + +item);

    //+'5' => kastva string kum number ako moje!!!
}

console.log(
    solve(1234)
);

console.log(
    solve(2222222)
);