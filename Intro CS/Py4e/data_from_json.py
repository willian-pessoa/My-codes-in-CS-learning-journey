from urllib.request import urlopen
import ssl
import json

#enter url
url = input("Enter location: ")
if len(url) < 1:
    url = "http://py4e-data.dr-chuck.net/comments_1332846.json"
print("Retrieving ", url)


# Ignore SSL certificate errors
ctx = ssl.create_default_context()
ctx.check_hostname = False
ctx.verify_mode = ssl.CERT_NONE
#read json
data = urlopen(url, context=ctx).read()
print("Retrieved: ", str(len(data)), " characters")


#programing
info = json.loads(data)
count = 0
total = 0
for item in info["comments"]:
    total += int(item["count"])

print("Sum:", str(total))