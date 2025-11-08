#List
#1.Create a list that contains integers. You need to return the sum of the list.
l1 = [54, 43, 2, 1, 5]
def sumList(elements):
    rc = 0
    for element in elements:
        rc += element
    return rc


#2. You are given a number k and a list arr[] that contains integers. You need to return list of numbers that are less than k.
def less(l):
    rc = []
    for item in l:
        if item >k:
            rc.append(item)
    return rc


#3. You are given a list arr that contains integers. You need to return average of the non negative integers.
def non_negAverage(l):
    count = 0
    for item in l:
        if item >= 0:
            count +=1
            rc += item
    return rc // count
