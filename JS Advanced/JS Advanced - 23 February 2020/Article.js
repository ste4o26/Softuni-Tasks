class Article {
    #comments;
    #likes;

    constructor(title, creator) {
        this.#comments = [];
        this.#likes = [];
        this.commentId = 1;
        this.title = title;
        this.creator = creator;
    }

    get likes() {
        if (this.#likes.length === 0) { return `${this.title} has 0 likes`; }
        if (this.#likes.length === 1) { return `${this.#likes[0].username} likes this article!`; }
        return `${this.#likes[0].username} and ${this.#likes.length - 1} others like this article!`;
    }

    isAlreadyLikedThisArticle(username) {
        let result = this.#likes.find(like => like.username === username);
        return result === undefined ? false : true;
    }

    like(username) {
        if (this.isAlreadyLikedThisArticle(username)) { throw new Error('You can\'t like the same article twice!'); }
        if (this.creator === username) { throw new Error('You can\'t like your own articles!'); }

        this.#likes.push({ username: username });
        return `${username} liked ${this.title}!`;
    }

    dislike(username) {
        if (!this.isAlreadyLikedThisArticle(username)) { throw new Error('You can\'t dislike this article!'); }

        this.#likes = this.#likes.filter(user => user.username !== username);
        return `${username} disliked ${this.title}`
    }

    comment(username, content, id) {
        let comment = this.#comments.find(comment => comment.id === id);
        if (comment === undefined || id === undefined) {
            comment = {
                id: this.commentId++,
                username: username,
                content: content,
                replies: []
            };

            this.#comments.push(comment);
            return `${username} commented on ${this.title}`;
        }

        let reply = {
            id: comment.id + (comment.replies.length / 10),
            username: username,
            content: content
        };
        reply.id = (reply.id + 0.1).toFixed(1);

        comment.replies.push(reply);

        return 'You replied successfully';
    }

    toString(sortingType) {
        const sortingTypes = {
            'asc': () => {
                this.#comments.sort((f, s) => f.id - s.id);
                this.#comments.forEach(comment => comment.replies.sort((f, s) => f.id - s.id));
            },

            'desc': () => {
                this.#comments.sort((f, s) => s.id - f.id);
                this.#comments.forEach(comment => comment.replies.sort((f, s) => s.id - f.id));
            },

            'username': () => {
                this.#comments.sort((f, s) => f.username.localeCompare(s.username));
                this.#comments.forEach(comment => comment.replies.sort((f, s) => f.username.localeCompare(s.username)));
            }
        }

        sortingTypes[sortingType]();

        let result = `Title: ${this.title}\nCreator: ${this.creator}\nLikes: ${this.#likes.length}\nComments:\n`;

        return this.#comments
            .reduce((acc, comment) => {
                acc = acc.concat(`-- ${comment.id}. ${comment.username}: ${comment.content}\n`);
                if (comment.replies.length !== 0) { comment.replies.forEach(reply => acc = acc.concat(`--- ${reply.id}. ${reply.username}: ${reply.content}\n`)) }
                return acc;
            }, result)
            .trim();
    }
}


let art = new Article("My Article", "Anny");

art.like("John");
console.log(art.likes);

art.dislike("John");
console.log(art.likes);

art.comment("Sammy", "Some Content");
console.log(art.comment("Ammy", "New Content"));

art.comment("Zane", "Reply", 1);
art.comment("Jessy", "Nice :)");

console.log(art.comment("SAmmy", "Reply@", 1));
console.log()

console.log(art.toString('username'));
console.log()

art.like("Zane");

console.log(art.toString('desc'));