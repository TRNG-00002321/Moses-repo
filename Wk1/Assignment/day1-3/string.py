#String
#1. Given a string s, you need to reverse it.
def reverse(s):
    s = list(s)
    if len(s) > 1:
        l = 0
        r = len(s) - 1
        while l < r:
            s[l], s[r] = s[r], s[l]
            l+=1
            r-=1
        return " ".join(s)
    else:
        return s[0]

#2. Given a string s, you need to check if it is palindrome or not. A palidrome is a string that reads the same from front and back.
def is_palindrome(s):
    if len(s) > 1:
        l = 0
        r = len(s)-1
        while l < r:
            if s[l].lower() != s[r].lower():
                print("False")
                break
            l += 1
            r -=1
    else:
        print("True")


# 3. Given a string s, and a pattern p. You need to find if p exists in s or not and return the starting index of p in s.
# If p does not exist in s then -1 will be returned.
#Here p and s both are case-sensitive. This is sliding window problem
def is_pattern(s, p):
    if len(p)>len(s):
        return -1
    elif p == s:
        pass

# Examples:
# Input: s = "Hello", p = "llo"
# Output: 2
# Explanation: llo starts from the second index in Hello.

#Dictionary
#1.Given an array arr[], find the first repeating element. The element should occur more than once and the index of its
# first occurrence should be the smallest.
# Examples:
# Input: arr[] = [1, 5, 3, 4, 3, 5, 6]
# Output: 2
#Explanation: 5 appears twice and its first appearance is at index 2 which is less than 3 whose first the occurring index is 3.
 
#Set
#1. You are given an array arr[] of size n. You have to insert all elements of arr[] into a set and return that set .You
# are also given a interger x. If x is found in set then erase it from set and print "erased x", otherwise, print "not found".

is_palindrome("Moses")
