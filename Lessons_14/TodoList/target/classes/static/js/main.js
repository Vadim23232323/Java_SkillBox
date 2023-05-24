$(function () {

    // Добавление динамических элементов
    const appendTodo = function (data) {
        var todoCode = '<h2 class="todo-name" data-id="' +
            data.id + '">' + data.name + '<hr></h2>';
        var todoDescription = '<h2 class="todo-description" data-id="' +
            data.id + '">' + data.description + '<hr></h2>';
        var editButton = '<button class="edit-todo-button ed-del-button" title="Редактировать запись" data-id="' + data.id + '" data-name="' + data.name + '" data-description="' + data.description + '"><i class="fa fa-pen" aria-hidden="true"></i></button>';
        var deleteButton = '<button class="delete-todo-button ed-del-button" title="Удалить запись" data-id="' + data.id + '"><i class="fa fa-window-close" aria-hidden="true"></i></button>';

        $('#todo-list-name')
            .append('<div>' + todoCode + '</div>');
        $('#todo-list-description')
            .append('<div>' + todoDescription + '</div>');
        $('#todo-list-ed-button')
            .append('<div>' + editButton + '</div>');
        $('#todo-list-del-button')
            .append('<div>' + deleteButton + '</div>');
    };

    // Удаление заметки delete todo form
    $(document).on('click', '.delete-todo-button', function () {
        var button = $(this);
        var todoId = button.data('id');
        $.ajax({
            method: "DELETE",
            url: '/todos/' + todoId,
            success: function () {
                var todo = {};
                var dataArray = $('#todo-form form').serializeArray();
                for (i in dataArray) {
                    todo[dataArray[i]['name']] = dataArray[i]['value'];
                }
                button.closest('.delete-todo-button').remove();
                $('.todo-description[data-id="' + todoId + '"]').closest('div').remove();
                $('.todo-name[data-id="' + todoId + '"]').closest('div').remove();
                $('.edit-todo-button[data-id="' + todoId + '"]').remove();
            },
            error: function () {
                alert('Ошибка при удалении записи!');
            }
        });
    });

    // Удаление всех заметок delete todo form
    $(document).on('click', '.clear-button', function () {
        $.ajax({
            method: "DELETE",
            url: '/todos/',
            success: function () {
                $('.todo-name').closest('div').remove();
                $('.todo-description').closest('div').remove();
                $('.edit-todo-button').remove();
                $('.delete-todo-button').remove();
                localStorage.clear();
            },
            error: function () {
                alert('Ошибка при удалении всех записей!');
            }
        });
    });



    //Закрытие формы todo form
    $('#todo-form').click(function (event) {
        if (event.target === this) {
            $(this).css('display', 'none');
        }
    });

    $('#todo-list-ed-button').on('click', '.edit-todo-button', function () {
        var button = $(this);
        var todoId = button.data('id');
        var todoName = button.data('name');
        var todoDescription = button.data('description');

        $('#todo-form').data('id', todoId);
        // Отобразить форму редактирования
        $('#save-todo').css('display', 'none');
        $('#save-todo-edit').css('display', 'flex');
        $('#todo-form').css('display', 'flex');
        $('#todo-form h1').text('Редактировать заметку');

        // Заполнить поля формы значениями текущей записи
        document.getElementById("name").value = todoName;
        document.getElementById("description").value = todoDescription;
    });

    // Редактирование заметки todo
    $('#save-todo-edit').click(function (event) {
        event.preventDefault();
        var todoId = $('#todo-form').data('id');
        var updatedTodo = {
            id: todoId,
            name: document.getElementById("name").value,
            description: document.getElementById("description").value
        };

        $.ajax({
            contentType: "application/json",
            method: "PUT",
            url: '/todos/' + todoId,
            data: JSON.stringify(updatedTodo),
            success: function () {
                $('#todo-form').css('display', 'none');
                var editedTodoLink = $('.todo-name[data-id="' + todoId + '"]');
                editedTodoLink.text(updatedTodo.name);
                var editedTodoDescription = $('.todo-description[data-id="' + todoId + '"]');
                editedTodoDescription.text(updatedTodo.description);
                updateButtonInfo(todoId, updatedTodo.name, updatedTodo.description);
                location.reload();
                clearForm();
            },
            error: function (xhr, status, error) {
                console.log(xhr.responseText);
                console.log(status);
                console.log(error);
                alert("Ошибка редакитрования заметки!");
            }
        });
    });

    //Открытие формы добавления заметки todo form
    $('#show-add-todo-form').click(function () {
        $('#save-todo').css('display', 'flex');
        $('#save-todo-edit').css('display', 'none');
        $('#todo-form').css('display', 'flex');
        $('#todo-form h1').text('Добавить заметку');
        clearForm();
    });

    //Добавление заметки todo
    $('#save-todo').click(function () {
        var data = $('#todo-form form').serialize();
        $.ajax({
            method: "POST",
            url: '/todos/',
            data: data,
            success: function (response) {
                $('#todo-form').css('display', 'none');
                var todo = {};
                todo.id = response;
                var dataArray = $('#todo-form form').serializeArray();
                for (i in dataArray) {
                    todo[dataArray[i]['name']] = dataArray[i]['value'];
                }
                appendTodo(todo);
                saveButtonInfo(todo);
                clearForm();
            }
        });
        return false;
    });

    //Очищаем элементы формы
    var clearForm = function () {
        document.getElementById("name").value = "";
        document.getElementById("description").value = "";
    };

    // Сохранение информации о кнопке при добавлении записи
    var saveButtonInfo = function (data) {
        var buttonInfo = {
            id: data.id,
            name: data.name,
            description: data.description
        };
        var buttons = JSON.parse(localStorage.getItem('todoButtons')) || [];
        buttons.push(buttonInfo);
        localStorage.setItem('todoButtons', JSON.stringify(buttons));
    };

    // Обновление кнопки редактирование 
    var updateButtonInfo = function (buttonId, newName, newDescription) {
        var editButton = $('.edit-todo-button[data-id="' + buttonId + '"]');
        editButton.attr('data-name', newName);
        editButton.attr('data-description', newDescription);

        var buttonInfo = {
            id: buttonId,
            name: newName,
            description: newDescription
        };
        var buttons = JSON.parse(localStorage.getItem('todoButtons')) || [];

        // Найти предыдущую кнопку с тем же id и удалить ее из массива
        buttons = buttons.filter(function (button) {
            return button.id !== buttonId;
        });
        buttons.push(buttonInfo);
        localStorage.setItem('todoButtons', JSON.stringify(buttons));
    };

    // Загрузка кнопок при загрузке страницы
    var loadButtons = function () {
        var buttons = JSON.parse(localStorage.getItem('todoButtons')) || [];

        for (var i = 0; i < buttons.length; i++) {
            var buttonInfo = buttons[i];
            var todoExists = $('#todo-list-name .todo-name[data-id="' + buttonInfo.id + '"]').length > 0;

            if (todoExists) {
                var editButton = '<button class="edit-todo-button ed-del-button" title="Редактировать запись" data-id="' + buttonInfo.id + '" data-name="' + buttonInfo.name + '" data-description="' + buttonInfo.description + '"><i class="fa fa-pen" aria-hidden="true"></i></button>';
                var deleteButton = '<button class="delete-todo-button ed-del-button" title="Удалить запись" data-id="' + buttonInfo.id + '"><i class="fa fa-window-close" aria-hidden="true"></i></button>';
                $('#todo-list-ed-button').append('<div>' + editButton + '</div>');
                $('#todo-list-del-button').append('<div>' + deleteButton + '</div>');
            }
        }
    };


    // Обновление кнопки редактирование 
    var updateButtonInfo = function (buttonId, newName, newDescription) {
        var editButton = $('.edit-todo-button[data-id="' + buttonId + '"]');
        editButton.attr('data-name', newName);
        editButton.attr('data-description', newDescription);

        var buttonInfo = {
            id: buttonId,
            name: newName,
            description: newDescription
        };
        var buttons = JSON.parse(localStorage.getItem('todoButtons')) || [];

        // Найти предыдущую кнопку с тем же id и удалить ее из массива
        buttons = buttons.filter(function (button) {
            return button.id !== buttonId;
        });
        buttons.push(buttonInfo);
        localStorage.setItem('todoButtons', JSON.stringify(buttons));
    };

    // Загрузка кнопок при загрузке страницы
    loadButtons();

});