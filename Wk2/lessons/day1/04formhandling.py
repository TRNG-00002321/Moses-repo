from flask import Flask, request, redirect, url_for

app = Flask(__name__)

@app.route('/login', methods=['GET', 'POST'])

def login():
    if request.method == 'POST':
        username = request.form['nm']
        return 'Welcome %s!' % username.upper()
    else:
        username = request.args.get('nm')

    return  'Welcome %s!' %username.upper() #redirect(url_for(endpoint="login", POST=username))#


if __name__ == '__main__':
    app.run(debug=True)
