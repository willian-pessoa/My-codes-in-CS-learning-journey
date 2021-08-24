import re

name = input("Enter file:")
try:
    handle = open(name)
except:
    quit()

total = 0
count = 0
for line in handle:
    numbers = re.findall("[0-9]+", line)
    if len(numbers) != 0:
        for number in numbers:
            count += 1
            total += int(number)

print(total)
print(count)
