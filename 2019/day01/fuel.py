import math

def calculate_fuel(gas):
  required = max(math.floor((gas/3)) - 2,0)
  if required > 0:
    required += calculate_fuel(required)
  return required


inputs = open("input.txt", "r")
sum = 0
for input in inputs:
  sum += calculate_fuel(int(input))

print(sum)
