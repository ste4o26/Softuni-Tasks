class Forum {
    #users;
    #questions;
    #id;

    constructor() {
        this.#users = [];
        this.#questions = [];
        this.#id = 1;
    }

    register(username, password, repeatPassword, email) {
        let user = this.#users.find(user => user.username === username || user.email === email);
        if (user !== undefined) {
            throw new Error('This user already exists!');
        }

        if (username === '' || password === '' || repeatPassword === '' || email === '') {
            throw new Error('Input can not be empty');
        }

        if (password !== repeatPassword) {
            throw new Error('Passwords do not match');
        }

        user = {
            username: username,
            password: password,
            email: email,
            isLoggedIn: false
        };

        // user = new User(username, password, repeatPassword, email);
        this.#users.push(user);

        return `${user.username} with ${user.email} was registered successfully!`;
    }

    login(username, password) {
        this.isExistingUser(username, password);

        let user = this.fetchUser(username, password);
        if (user !== undefined) {
            user.isLoggedIn = true;
            return 'Hello! You have logged in successfully';
        }
    }

    logout(username, password) {
        this.isExistingUser(username, password);

        let user = this.fetchUser(username, password);
        if (user !== undefined) {
            user.isLoggedIn = false;
            return 'You have logged out successfully';
        }
    }

    isExistingUser(username, password) {
        let user = this.#users.find(user => user.username === username);
        if (user === undefined) {
            throw new Error('There is no such user');
        }
    }

    fetchUser(username, password) {
        return this.#users.find(user => user.username === username && user.password === password);
    }

    postQuestion(username, question) {
        let user = this.findLoggedUserByUsername(username);

        if (user === undefined) {
            throw new Error('You should be logged in to post questions');
        }

        if (question.trim() === '') {
            throw new Error('Invalid question');
        }

        this.#questions.push({
            id: this.#id,
            content: question,
            publisher: username,
            answers: []
        });
        this.#id++;

        return 'Your question has been posted successfully';
    }

    postAnswer(username, questionId, answer) {
        let user = this.findLoggedUserByUsername(username);

        if (user === undefined) {
            throw new Error('You should be logged in to post answers');
        }

        if (answer === '') {
            throw new Error('Invalid answer');
        }

        let question = this.#questions.find(question => question.id === questionId);

        if (question === undefined) {
            throw new Error('There is no such question');
        }

        question.answers.push({ content: answer, publisher: username });
        return 'Your answer has been posted successfully';
    }

    findLoggedUserByUsername(username) {
        return this.#users.find(user => user.username === username && user.isLoggedIn === true);
    }

    showQuestions() {
        return this.#questions
            .reduce((acc, question) => {
                acc = acc.concat(`Question ${question.id} by ${question.publisher}: ${question.content}\n`);
                question.answers.map(answer => acc = acc.concat(`---${answer.publisher}: ${answer.content}\n`));
                return acc;
            }, ``)
            .trim();
    }
}

// class User {
//     constructor(username, password, repeatPassword, email) {
//         if (username.trim() === '' || password.trim() === '' || repeatPassword.trim() === '' || email.trim() === '') {
//             throw new Error('Input can not be empty');
//         }

//         if (password !== repeatPassword) {
//             throw new Error('Passwords do not match');
//         }

//         this.username = username;
//         this.password = password;
//         this.repeatPassword = repeatPassword;
//         this.email = email;
//         this.isLoggedIn = false;
//     }
// }

// test 1:
let forum = new Forum();

forum.register('Michael', '123', '123', 'michael@abv.bg');
forum.register('Stoyan', '123ab7', '123ab7', 'some@gmail@.com');

forum.login('Michael', '123');
forum.login('Stoyan', '123ab7');

forum.postQuestion('Michael', "Can I rent a snowboard from your shop?");

forum.postAnswer('Stoyan', 1, "Yes, I have rented one last year.");
forum.postQuestion('Stoyan', "How long are supposed to be the ski for my daughter?");
forum.postAnswer('Michael', 2, "How old is she?");
forum.postAnswer('Michael', 2, "Tell us how tall she is.");

console.log(forum.showQuestions());

//test 2:
// let forum = new Forum();

// forum.register('Jonny', '12345', '12345', 'jonny@abv.bg');
// forum.register('Peter', '123ab7', '123ab7', 'peter@gmail@.com');

// forum.login('Jonny', '12345');
// forum.login('Peter', '123ab7');

// forum.postQuestion('Jonny', "Do I need glasses for skiing?");

// forum.postAnswer('Peter', 1, "Yes, I have rented one last year.");
// forum.postAnswer('Jonny', 1, "What was your budget");
// forum.postAnswer('Peter', 1, "$50");
// forum.postAnswer('Jonny', 1, "Thank you :)");

// console.log(forum.showQuestions());