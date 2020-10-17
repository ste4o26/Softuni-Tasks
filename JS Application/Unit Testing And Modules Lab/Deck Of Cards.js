function createCard(face, suit) {
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
            if (!faces.includes(face)) throw new Error(`Invalid card: ${face}${suit}`);
            this.#face = face;
        }

        set suit(suit) {
            if (suits[suit] === undefined) throw new Error(`Invalid card: ${face}${suit}`);
            this.#suit = suits[suit];
        }

        toStirng() {
            return `${this.#face}${this.#suit}`;
        }
    }

    return new Card(face, suit).toStirng();
}

function printDeckOfCards(cards) {
    const result = [];
    const errLoger = [];

    for (const card of cards) {
        const cardData = card.split('')
        let [face, suit] = cardData;

        if (cardData.length === 3) {
            face = cardData[0].concat(cardData[1]);
            suit = cardData[2];
        }

        try {
            result.push(createCard(face, suit));
        } catch (exc) {
            return exc.message;
        }
    }

    return result.join(' ');
}


//v judge raboti s console.log a ne s return!!!

console.log(
    printDeckOfCards(['5S', '3D', 'QD'])
);