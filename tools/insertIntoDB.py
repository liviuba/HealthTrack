from pymongo import MongoClient
import sys
import subprocess
import time


crawlerOutputFile = 'temp_file.txt'
client = MongoClient()
db = client.test

def startCrawler(crawlerName):
	print crawlerName
	proc = subprocess.check_output(['python', crawlerName, crawlerOutputFile])
	

def processOutput():
	f = open(crawlerOutputFile, 'r')
	products = []
	line = f.readline()
	products.append(line)
	while line:
		line = f.readline()
		products.append(line)
	insertIntoDb(products)
	f.closed


def insertIntoDb(products) :
	entry = {
		'date': time.strftime("%d/%m/%Y"),
		'parserName': sys.argv[1],
		'website' : 'www.minimix.ro', # TO DO: remove that
		'products' : products
	}
	db.wordlist.insert_one(entry)

def main():
	if (len(sys.argv)) == 1:
		raise ValueError('Crawler name not given, you stupid programmer!')
	else:
		startCrawler(sys.argv[1])
		processOutput()

if __name__ == "__main__":
	main()