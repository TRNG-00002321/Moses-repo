#List
import _functools
from functools import reduce

#1.Create a list that contains integers. You need to return the sum of the list.
l1 = [54, 43, 2, 1, 5]
def sum_list(elements):
    # rc = 0
    # for element in elements:
    #     rc += element
    return reduce(lambda x, y: x + y, elements) # A clearner way to solve this problem using reduce and lambda functions


#2. You are given a number k and a list arr[] that contains integers. You need to return list of numbers that are less than k.
def less(l,k):
    # rc = []
    # for item in l:
    #     if item > k:
    #         rc.append(item)
    # Another to handle this problem
    return list(filter(lambda x: x < k, l))


#3. You are given a list arr that contains integers. You need to return average of the non negative integers.
def non_neg_average(l):
    count = 0
    rc  = 0
    for item in l:
        if item >= 0:
            count +=1
            rc += item
    return rc // count
