name = input("Enter file:")
if len(name) < 1:
    name = "mbox-short.txt"
handle = open(name)

# find emails and count how many times apear in a dictionarie
count_email = dict()
for line in handle:
    if not line.startswith("From:"):
        continue
    words = line.split()
    count_email[words[1]] = count_email.get(words[1], 0) + 1

bigcount = None
big_email = None
for email,count in count_email.items():
    if bigcount is None or count > bigcount:
        big_email = email
        bigcount = count

print(big_email, bigcount)



    