from flask import Flask
app = Flask(__name__)

@app.route('/')
def hello_world():
    return 'Hello World!'

@app.route('/do-ocr/')
def pushForOCR():
  strImagePath = request.args.get("path").lower()

  ##Call OCR engine for image @ strImagePath here

if __name__ == '__main__':
  app.debug = True
  app.run(host="0.0.0.0")
