def user_input():
    values = input().split()
    return int(values[0]), int(values[1])
def cycle_length(n):
    m = 1
    while n != 1:
        m += 1
        if n % 2 == 0:
            n = n / 2
        else:
            n =  3 * n + 1
    return m

def maximum_cycle_length(i, j):
    m = 0
    for n in range(i, j + 1):
        if m < cycle_length(n):
            m = cycle_length(n)
    return str(i) + " " + str(j) + " " + str(m)

x, y = user_input()
z = maximum_cycle_length(x, y)
print(z)
