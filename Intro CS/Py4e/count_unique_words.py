fname = input("Enter file name: ")
try:
	fh = open(fname)
except:
    print("invalid entry")
    quit()

lst = list()
for line in fh:
	words = line.split()
        print(words)
        for word in words:
            if lst is None:
                lst.append(word)
            if word not in lst:
                lst.append(word)

print(lst)

     
