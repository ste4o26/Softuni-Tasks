function solve(input) {
    //reshenieto na chaov baq e dobro :D
    // return [
    //     ...new Set(input.join('')
    //         .toLowerCase()
    //         .match(/\w+/gim))
    // ].join(', ');



    return input.map(item => item.split(/[^\w]+/gim))
        .reduce((accumolator, data) => {
            data.map(item => item.toLowerCase())
                .map(item => {
                    item !== '' && !accumolator.includes(item) ? accumolator.push(item) : null;
                });
            return accumolator;
        }, []).join(', ');
}


console.log(
    solve(['Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
        'Pellentesque quis hendrerit dui.',
        'Quisque fringilla est urna, vitae efficitur urna vestibulum fringilla.',
        'Vestibulum dolor diam, dignissim quis varius non, fermentum non felis.',
        'Vestibulum ultrices ex massa, sit amet faucibus nunc aliquam ut.',
        'Morbi in ipsum varius, pharetra diam vel, mattis arcu.',
        'Integer ac turpis commodo, varius nulla sed, elementum lectus.',
        'Vivamus turpis dui, malesuada ac turpis dapibus, congue egestas metus.'])
);