# Use the file name mbox-short.txt as the file name
fname = input("Enter file name: ")
try:
    fh = open(fname)
except:
    print("Invalid Entry")
    quit()

count = 0
total = 0
for line in fh:
    if not line.startswith("X-DSPAM-Confidence:"):
        continue
    count += 1

    #look to value and sum
    start = line.find(":")
    number = float(line[start+1:].strip())
    total += number

print("Average spam confidence:", total / count)

