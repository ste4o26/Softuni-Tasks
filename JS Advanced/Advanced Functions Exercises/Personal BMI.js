function solve(...input) {
    let [personName, personAge, weightKG, heightCM] = [...input];

    return (function () {
        name = personName;

        personalInfo = {
            age: personAge,
            weight: weightKG,
            height: heightCM
        };

        function BMI() {
            return Math.round(personalInfo.weight / (personalInfo.height / 100) ** 2);
        }

        function status() {
            return BMI() < 18.5 ? 'underweight'
                : BMI() < 25 ? 'normal'
                    : BMI() < 30 ? 'overweight'
                        : 'obese';
        }

        const person = {
            name: name,
            personalInfo: personalInfo,
            BMI: BMI(),
            status: status()
        };

        if (person.status === 'obese') {
            person.recommendation = 'admission required';
        }

        return person;
    })();
}

console.log(
    solve('Peter', 29, 75, 182)
);

console.log(
    solve('Honey Boo Boo', 9, 57, 137)
)