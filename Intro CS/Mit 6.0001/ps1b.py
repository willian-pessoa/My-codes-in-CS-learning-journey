# -*- coding: utf-8 -*-
"""
Created on Sat Aug 21 19:17:51 2021

@author: willi
"""

portion_down_payment = 0.25
current_saving = 0.0
r = 0.04

annual_salary = float(input("Enter your annual salary:"))
portion_saved = float(input("Enter the percent of your salary to save, as a decimal:"))
total_cost = float(input("Enter the cost of your dream home:"))
semi_annual_raise = float(input("Enter the semi-­annual raise, as a decimal:"))


monthly_salary = annual_salary / 12

# increase the saving to count the months
months = 1
while current_saving < total_cost * portion_down_payment:
    # update salary
    if months % 6 == 0:
        annual_salary += annual_salary * semi_annual_raise
        monthly_salary = annual_salary / 12
    
    current_saving += monthly_salary * portion_saved
    current_saving += current_saving * r / 12 # return
    months += 1
    
print("Number of months:", months )
    
    