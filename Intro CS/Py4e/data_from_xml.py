from urllib.request import urlopen
import xml.etree.ElementTree as ET
import ssl
#enter url
url = input("Enter location: ")
if len(url) < 1:
    url = "http://py4e-data.dr-chuck.net/comments_1332845.xml"
print("Retrieving ", url)


# Ignore SSL certificate errors
ctx = ssl.create_default_context()
ctx.check_hostname = False
ctx.verify_mode = ssl.CERT_NONE
#read xml
xml = urlopen(url, context=ctx).read()
print("Retrieved: ", str(len(xml)), " characters")

#programing
tree = ET.fromstring(xml)
counts = tree.findall('.//count')
print("Count: " + str(len(counts)))

total = 0
for count in counts:
    total += int(count.text)

print("Sum:" + str(total))