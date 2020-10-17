function solve(input) {
    return input
        .reduce((acc, data) => {
            let [width, height] = data;

            const rectanlge = {
                width: Number(width),
                height: Number(height),
                area: function () { return this.width * this.height },
                compareTo: function (other) { return (this.area() - other.area()) }
            }

            acc.push(rectanlge);
            return acc;
        }, [])
        .sort((f, s) => s.area() - f.area() || s.width - f.width)
}

//compareTo function does not work properly!!!

console.log(solve([[10, 5], [5, 12]]));