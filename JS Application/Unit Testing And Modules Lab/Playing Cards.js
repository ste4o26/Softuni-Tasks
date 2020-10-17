function solve(face, suit) {
    const suits = {
        S: '\u2660',
        H: '\u2665',
        D: '\u2666',
        C: '\u2663'
    }

    const faces = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A'];

    class Card {
        #face;
        #suit;

        constructor(face, suit) {
            this.face = face;
            this.suit = suit;
        }

        set face(face) {
            if (!faces.includes(face)) throw new Error('Invalid face!');
            this.#face = face;
        }

        set suit(suit) {
            if (suits[suit] === undefined) throw new Error('Invalid suit!');
            this.#suit = suits[suit];
        }

        toStirng() {
            return `${this.#face}${this.#suit}`;
        }
    }

    return new Card(face, suit).toStirng();
}

console.log(
    solve('A', 'S')
);