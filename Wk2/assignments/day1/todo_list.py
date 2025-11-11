# To-Do List Manager: Create a program to add, view, mark as complete, and delete tasks from a list/dictionary,
# potentially saving the list/dictionary to a file. Please use the following as well while writing code

import json
from flask import Flask, render_template, request, redirect, url_for
from todo_methods import save_task, load_todos, delete_task

app = Flask(__name__)
@app.route('/todo', methods=['GET', 'POST' ])
def add_task():
    if request.method == 'POST':
        title = request.form['item']
        description = request.form['description']
        task = {"name": title, "description": description, 'status': "incomplete"}
        save_task(task)
        return redirect(url_for('add_task'))
    return render_template('todo.html', todos = load_todos())

@app.route('/delete_todo', methods=['POST'])
def delete_todo():
    name = request.form['item']
    delete_task(name)
    return render_template('todo.html', todos=load_todos())

if __name__ == '__main__':
    app.run(debug=True)