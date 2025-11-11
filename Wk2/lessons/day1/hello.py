from contextlib import redirect_stderr

from flask import Flask, redirect, url_for

app = Flask(__name__)

@app.route('/')
def hello_world():
    return 'Hello, Flask!'
# @app.route('/square/<int:num>')
# def hisquare(num):
#     return num ** 2
#
# @app.route('/float/<float:num>')
# def hifloat(num):
#     return num + 5.5

# Circle Area

# Method to display the sum of two numbers
# @app.route('/sum/<int:num1>/<int:num2>')
# def hisum(num1, num2):
#     return str(num1 + num2)
# # two users, Admin and Guest user

def hello_admin(admin):
    return 'Hello Admin! %s' %admin.upper()

def hello_guest(guest):
    return 'Hello guest! %s' %guest.upper()
@app.route('/user/<name>')
def hello_user(name):
    if name == 'admin':
        return redirect(url_for('hello_admin',admin=name)) # Using the redirect and url_for for a dynamnic
        # return 'hi Admin!, %s' % name
    else:
        return 'Hi Guest %s' % name

if __name__ == '__main__':
    app.run(debug=True)



