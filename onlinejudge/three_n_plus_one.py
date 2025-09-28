# Problem link: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=36
import sys

seen = dict()

def user_input(line):
    values = line.split()
    return int(values[0]), int(values[1])

def cycle_length(n):
    seq = []
    while n != 1:
        if n in seen:
            break
        seq.append(n)
        if n % 2 == 0:
            n = n / 2
        else:
            n =  3 * n + 1
    
    m = seen[n]
    for i in reversed(seq):
        m = m + 1
        seen[i] = m

    return m

def maximum_cycle_length(i, j):
    m = 0
    a = i
    b = j
    if i > j:
        i, j = j, i
    for n in range(i, j + 1):
        if m < cycle_length(n):
            m = cycle_length(n)
    return str(a) + " " + str(b) + " " + str(m)


seen[1] = 1
for line in sys.stdin:
    x, y = user_input(line)
    z = maximum_cycle_length(x, y)
    print(z)
