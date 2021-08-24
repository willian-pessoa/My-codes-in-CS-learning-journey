largest = None
smallest = None
go = 0
while True:
    num = input("Enter a number: ")
    if num == "done":
        break

    try:
        num = int(num)
        go = 1
    except:
        print("Invalid Input")
        go = 0
        
    if go == 1:
        if smallest is None:
            smallest = num
        if largest is None:
            largest = num
        
        if num < smallest:
            smallest = num
        if num > largest:
            largest = num


print("Maximum is", largest)
print("Minimum is", smallest)
