function solve() {
    const addButton = document.querySelector('#add');
    addButton.addEventListener('click', addNewTask);

    function addNewTask(e) {
        const openSection = document.querySelector('section div .orange').parentElement.nextElementSibling;

        e.preventDefault();
        let [task, description, dueDate] = [
            this.parentElement.children[2].value,
            this.parentElement.children[6].value,
            this.parentElement.children[9].value
        ];

        if (task.trim() === '' || description.trim() === '' || dueDate.trim() === '') { throw new Error('Invalid input!') }

        let article = document.createElement('article');

        let taskTitle = document.createElement('h3');
        taskTitle.textContent = task;
        article.appendChild(taskTitle);

        let descriptionParagprah = document.createElement('p');
        descriptionParagprah.textContent = `Description: ${description}`;
        article.appendChild(descriptionParagprah);

        let dueDateParagraph = document.createElement('p');
        dueDateParagraph.textContent = `Due Date: ${dueDate}`;
        article.appendChild(dueDateParagraph);

        let container = document.createElement('div');
        container.className = 'flex';

        let startButton = document.createElement('button');
        startButton.className = 'green';
        startButton.textContent = 'Start';
        startButton.addEventListener('click', startTask);
        container.appendChild(startButton);


        let deleteButton = document.createElement('button');
        deleteButton.className = 'red';
        deleteButton.textContent = 'Delete';
        deleteButton.addEventListener('click', deleteArticle);
        container.appendChild(deleteButton);

        article.appendChild(container);
        openSection.appendChild(article);
    }


    function startTask(e) {
        const inProgressSection = document.querySelector('section div .yellow').parentElement.nextElementSibling;
        let article = this.parentElement.parentElement;

        this.parentElement.parentElement.remove();
        article.children[3].firstElementChild.remove();

        let finishButton = document.createElement('button');
        finishButton.className = 'orange';
        finishButton.textContent = 'Finish';
        finishButton.addEventListener('click', finishTask);
        article.children[3].appendChild(finishButton);

        inProgressSection.appendChild(article);
    }

    function deleteArticle(e) {
        this.parentElement.parentElement.remove();
    }

    function finishTask(e) {
        const completeSection = document.querySelector('section div .green').parentElement.nextElementSibling;
        let article = this.parentElement.parentElement;
        article.children[3].remove();
        completeSection.appendChild(article);
    }
}

