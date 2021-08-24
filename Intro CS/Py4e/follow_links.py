# To run this, download the BeautifulSoup zip file
# http://www.py4e.com/code3/bs4.zip
# and unzip it in the same directory as this file

import urllib.request, urllib.parse, urllib.error
from bs4 import BeautifulSoup
import ssl

# Ignore SSL certificate errors
ctx = ssl.create_default_context()
ctx.check_hostname = False
ctx.verify_mode = ssl.CERT_NONE

url = input('Enter - ')
html = urllib.request.urlopen(url, context=ctx).read()
soup = BeautifulSoup(html, 'html.parser')

position = int(input("Enter Position:"))
times = int(input("Enter Times:"))

# Retrieve all of the anchor tags
for i in range(times):
    count_position = 0
    tags = soup('a')
    for tag in tags:
        count_position += 1
        if count_position == position:
            print("Retrieve", tag.get('href', None))
            url = tag.get('href', None)
            html = urllib.request.urlopen(url, context=ctx).read()
            soup = BeautifulSoup(html, 'html.parser')
            


