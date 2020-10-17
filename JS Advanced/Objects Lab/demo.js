// //@ts-check
// // Curring example!!!
// function tripleSum(a) {
//     return function (b) {
//         return function (c) {
//             return a + b + c;
//         }
//     }
// }


// let first = tripleSum(5);
// let second = first(3);
// let third = second(2);
// console.log(third);

//private fields examples!
// const person = (function () {
//     let firstName;
//     let lastName;
//     let age;

//     function getAge() {
//         return age;
//     }

//     function setAge(_age) {
//         if (_age < 0) {
//             console.log('Invalid Age!');
//         } else {
//             age = _age;
//         }
//     }

//     function getFirstName() {
//         return firstName;
//     }

//     function setFirstName(_firstName) {
//         firstName = _firstName;
//     }

//     function getLastName() {
//         return lastName;
//     }

//     function setLastName(_lastName) {
//         lastName = _lastName;
//     }

//     return {
//         getFirstName: getFirstName,
//         setFirstName: setFirstName,
//         getLastName: getLastName,
//         setLastName: setLastName,
//         // firstName: firstName,
//         // lastName: lastName,
//         getAge: getAge,
//         setAge: setAge
//     };
// })();

// // console.log(person.firstName);
// // console.log(person.lastName);
// // console.log(person.getAge());


// person.setFirstName('Ivan');
// person.setLastName('Ivanov');
// person.setAge(58);
// // person.firstName = 'Ivan'
// // person.lastName = 'Georgievd'


// console.log(person.getFirstName());
// console.log(person.getLastName());
// console.log(person.getAge());


//// simple prototype extension example
// const person = {
//     name: 'Stefan',
//     age: 26
// };

// const person2 = Object.create(person);

// //tuk ne se pechata nishto ponejve proverqvam dali tekushtiq obekt ima
// //propertitata a ne gi vzemam ot prototipa na obekta cherez koito sum go konstroiral
// for (const key in person2) {
//     if (person2.hasOwnProperty(key)) {
//         console.log(person2[key]);
//     }
// }

// person2.name = 'Ivan';
// person2.age = 15;

// console.log(person);
// console.log(person2);