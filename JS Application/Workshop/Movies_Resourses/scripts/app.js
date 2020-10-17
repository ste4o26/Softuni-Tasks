import router from './router.js';

window.addEventListener('load', solve);

function solve() {
    const app = Sammy('#container', router);
    app.run();
}

