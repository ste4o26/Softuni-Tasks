function solve() {
    class Balloon {
        constructor(color, gasWeight) {
            this.color = color;
            this.gasWeight = gasWeight;

        }
    }

    class PartyBalloon extends Balloon {
        ribbon;

        constructor(color, gasWeight, ribbonColor, ribbonLength) {
            super(color, gasWeight);
            this.ribbon = { color: ribbonColor, length: ribbonLength };
        }

        set ribbon(ribbon) {
            this.ribbon = ribbon;
        }

        get ribbon() {
            return this.ribbon;
        }
    }

    class BirthdayBalloon extends PartyBalloon {
        text;

        constructor(color, gasWeight, ribbonColor, ribbonLength, text) {
            super(color, gasWeight, ribbonColor, ribbonLength);
            this.text = text;
        }

        set text(text) {
            this.text = text;
        }

        get text() {
            return this.text;
        }
    }

    return {
        Balloon: Balloon,
        PartyBalloon: PartyBalloon,
        BirthdayBalloon: BirthdayBalloon
    };
}