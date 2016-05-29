from flask import Flask
from flask import request
from flask import Response
from pymongo import MongoClient
import json

app = Flask(__name__)
client = MongoClient(['127.0.0.1'])["dummies"]

##
# @return userJSON
##
@app.route('/userAuth')
def userAuth():
  strUsername = request.args.get("username")
  strUserPassword = request.args.get("password")

  #if it looks stupid and it works it's not stupid!
  user = json.dumps(
    client.users.find(
      {
        "username": strUsername,
        "password": strUserPassword
      },
      {"_id":0}
    )[0]
  )

  rsp = Response(
    response=user,
    status=200,
    mimetype="application/json"
  )

  return rsp



@app.route('/getBasket')
def getBasket():
  nBasketID = int(
    request.args.get("basket")
  )

  basket = json.dumps(
    client.baskets.find(
      {
        "id": nBasketID
      },
      {"_id":0}
    )[0]
  )

  rsp = Response(
    response=basket,
    status=200,
    mimetype="application/json"
  )

  return rsp



@app.route('/getBasketItem')
def getBasketItem():
  nBasketItemID = int(
    request.args.get("basketItem")
  )

  basketItem = json.dumps(
    client.basketItems.find(
      {
        "id": nBasketItemID
      },
      {"_id":0}
    )[0]
  )

  rsp = Response(
    response=basketItem,
    status=200,
    mimetype="application/json"
  )

  return rsp


@app.route('/getProduct')
def getProduct():
  nProductID = int(
    request.args.get("product")
  )

  products = client.products.find(
      {
        "id": nProductID
      },
      {"_id":0}
    )

  product = json.dumps(
    client.products.find(
      {
        "id": nProductID
      },
      {"_id":0}
    )[0]
  )

  rsp = Response(
    response=product,
    status=200,
    mimetype="application/json"
  )

  return rsp


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