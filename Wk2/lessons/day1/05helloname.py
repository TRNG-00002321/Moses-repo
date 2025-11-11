from flask import Flask, render_template

app = Flask(__name__)

@app.route('/score/<int:score>')
def hello_world(score):
    return render_template('scores.html', marks=score)

@app.route('/hello/<name>')
def hello_name(name):
    return render_template('helloname.html', name=name)

@app.route('/subjects')
# A dictionary of subjects for and scores to render in an html template
def hello_subject():
    subjects = {'phy':50, 'Chemistry':60, 'math':70}
    return render_template('subject.html', subjects=subjects)

if __name__ == '__main__':
    app.run(debug=True)