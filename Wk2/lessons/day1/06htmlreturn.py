from flask import Flask, render_template
# Program to display score base on the user input of marks
app = Flask(__name__)

@app.route('/scores/<int:score>')
def hello_score(score):
    return render_template('scores.html', marks=score)

if __name__ == '__main__':
    app.run(debug=True)