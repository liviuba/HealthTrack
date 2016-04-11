import urllib2
from bs4 import BeautifulSoup
import sys
import time




subCats = set()
urls = ["http://www.minimix.ro/bauturi.1001/","http://www.minimix.ro/alimente.1000/"]


def hasNumbers(inputString):
	return any(char.isdigit() for char in inputString)

wordlist = open('./'+ sys.argv[1] , 'w')
products = set()

def nameToWordlist(url, product_name, category):
	words = product_name.split();
	if hasNumbers(words[len(words) - 1]):
		words.remove(words[len(words) - 1])
	response = " ".join(words)
	if response not in products:
		products.add(response)
		wordlist.write(response)
		wordlist.write('\n')
		wordlist.flush()
		print response





#get subcategories
def getSubCats():
	global subCats
	for url in urls:
		text = urllib2.urlopen(url).read()
		soup = BeautifulSoup(text)
		data = soup.find('div',attrs={'class':'BoxContainer'})
		links = data.findAll('a')
		for a in links:
		    subCats.add(a['href'])
	subCats = set(subCats)



#get products and prices
def getProductsAndPrices():
	while len(subCats) != 0:
		#sys.stdout.write('=')
		#sys.stdout.flush()
		productsToVisit = []
		actual_link = subCats.pop()
		text = urllib2.urlopen(actual_link).read()
		soup = BeautifulSoup(text)

		category = actual_link.split('/')[3].split('.')[0]

		data = soup.findAll('div', attrs={'class':'ListingTitleBox'})
		for p in data:
			href = p.find('a');
			productsToVisit.append(href['href'])
		nextPage = soup.find('a', attrs={'rel':'next'})
		if nextPage is not None:
			subCats.add(nextPage['href'])
		for product in productsToVisit:
			# sys.stdout.write('=')
			# sys.stdout.flush();
			product_page = urllib2.urlopen(product).read()
			productSoup = BeautifulSoup(product_page)
			div = productSoup.find('div', attrs={'class':'ProdTopBox'})
			product_name = div.find('h1').text
			nameToWordlist(product, product_name, category)



sys.stdout.write('\nCrawling [==')
sys.stdout.flush();

getSubCats()
getProductsAndPrices()


sys.stdout.write('>]\nDone!\n')
