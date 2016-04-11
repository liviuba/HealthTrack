from flask import Flask
import subprocess
app = Flask(__name__)

@app.route('/')
def hello_world():
    return 'Hello World!'


@app.route('/do-ocr/')
def pushForOCR():
  strImagePath = request.args.get("path").lower()

  # 'text' variable contains the text from @strImagePath
  text = subprocess.check_output(['tesseract', strImagePath, 'stdout'])
  

if __name__ == '__main__':
  app.debug = True
  app.run(host="0.0.0.0")
