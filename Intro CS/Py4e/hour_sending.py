name = input("Enter file:")
if len(name) < 1:
    name = "mbox-short.txt"
handle = open(name)

# find hour and count how many times apear in a dictionarie
hours_send = dict()
for line in handle:
    if line.startswith("From"):
        if line.startswith("From:"):
            continue
        hours = line.split()
        hour = hours[5].split(":")
        tirateima = hour[0]
        hours_send[tirateima] = hours_send.get(tirateima, 0) + 1

temp_hours = list()
for key, val in hours_send.items():
    tup = (key, val)
    temp_hours.append(tup)

temp_hours = sorted(temp_hours)

for key, val in temp_hours:
    print(key, val)

