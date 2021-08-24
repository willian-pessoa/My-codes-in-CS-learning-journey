# -*- coding: utf-8 -*-
"""
Created on Sat Aug 21 19:33:19 2021

@author: willi
"""
# constants
portion_down_payment = 0.25
current_saving = 0.0
r = 0.04
annual_salary = float(input("Enter your annual salary:"))
total_cost = 1000000.0
semi_annual_raise = 0.07

# compute save in 36 months
def saved(current, annual, portion, r, s):
    annual_salary = annual
    monthly_salary = annual / 12
    current_saving = current
    for month in range(1, 37):
        if month % 6 == 0:
            annual_salary += (annual * s)
            monthly_salary = annual_salary / 12
        
        current_saving += monthly_salary * portion
        current_saving += current_saving * r / 12 # return
    return current_saving

# bisection parameters
epsilon = 100
low = 0
high = 10000
bissection_count = 0
down_pay = total_cost * portion_down_payment
while True:
    #compute de saving changing the portion saved
    current_saving = 0
    portion_saved = (low + high) / 20000.0
    current_saving = saved(current_saving, annual_salary, portion_saved, r, semi_annual_raise)
    
    # check the save after 36 months
    if bissection_count > 50:
        portion_saved = "It is not possible to pay the down payment in three years."
        break
    elif (down_pay - current_saving) > epsilon:
        low = int(portion_saved * 10000)
        bissection_count += 1
    elif (down_pay - current_saving) < (-epsilon):
        high = int(portion_saved * 10000)
        bissection_count += 1
    else:
        break
    
if isinstance(portion_saved, str):
    print(portion_saved)
else:
    print("Steps in bisseciton: ", bissection_count)
    print("Best saving rate: ", portion_saved)
    


        

    
    
    
    










