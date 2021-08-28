# Problem Set 4A
# Name: <your name here>
# Collaborators:
# Time Spent: x:xx

def get_permutations(sequence):
    '''
    Enumerate all permutations of a given string

    sequence (string): an arbitrary string to permute. Assume that it is a
    non-empty string.  

    You MUST use recursion for this part. Non-recursive solutions will not be
    accepted.

    Returns: a list of all permutations of sequence

    Example:
    >>> get_permutations('abc')
    ['abc', 'acb', 'bac', 'bca', 'cab', 'cba']

    Note: depending on your implementation, you may return the permutations in
    a different order than what is listed here.
    '''
    
    perm_list = list()
    
    #BASE
    if len(sequence) == 1:
        perm_list.append(sequence)
        return perm_list
    else:
        for perm in get_permutations(sequence[1:]):
            for i in range(len(perm)+1):
                if i == 0:
                    perm_list.append(sequence[0] + perm[i:])
                elif i == len(perm)+1:
                    perm_list.append(perm[:i-1] + sequence[0])
                else:
                    perm_list.append(perm[:i] + sequence[0] + perm[i:])
    
    perm_list = set(perm_list)
    return perm_list



if __name__ == '__main__':
#    #EXAMPLE
#    example_input = 'abc'
#    print('Input:', example_input)
#    print('Expected Output:', ['abc', 'acb', 'bac', 'bca', 'cab', 'cba'])
#    print('Actual Output:', get_permutations(example_input))
    
#    # Put three example test cases here (for your sanity, limit your inputs
#    to be three characters or fewer as you will have n! permutations for a 
#    sequence of length n)
    print("----TEST----")

    ana1 = "aab"
    print("Test 1:", ana1)
    print("Excpected: aba, baa, aab")
    print('Actual Output:', get_permutations(ana1))
    print()
    ana2 = "ab"
    print("Test 2:", ana2)
    print("Excpected: [ab, ba]")
    print('Actual Output:', get_permutations(ana2))
    print()
    ana3 = "abc"
    print("Test 3:", ana3)
    print("Excpected: [abc, acb, bac, bca, cab, cba]")
    print('Actual Output:', get_permutations(ana3))
    print()

