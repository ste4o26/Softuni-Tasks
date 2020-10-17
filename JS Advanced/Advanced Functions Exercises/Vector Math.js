const vector = (function () {
    function add (vector1, vector2) {
        return [vector1[0] + vector2[0], vector1[1] + vector2[1]];
    }

    function multiply(vector, value) {
        return [vector[0] * value, vector[1] * value];
    }

    function length(vector) {
        return Math.sqrt(vector[0] * vector[0] + vector[1] * vector[1]);
    }

    function dot(vector1, vector2) {
        return vector1[0] * vector2[0] + vector1[1] * vector2[1];
    }

    function cross(vector1, vector2) {
        return vector1[0] * vector2[1] - vector1[1] * vector2[0];
    }

    return {
        add,
        multiply,
        length,
        dot,
        cross
    };
})();

console.log(
    vector.add([1, 1], [1, 0])
);

console.log(
    vector.multiply([3.5, -2], 2) 
);

console.log(
    vector.length([3, -4])
);

console.log(
    vector.dot([2, 3], [2, -1])
);

console.log(
    vector.cross([3, 7], [1, 0])
);