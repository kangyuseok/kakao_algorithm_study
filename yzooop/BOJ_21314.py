import sys

mk = list(sys.stdin.readline().strip())

m_cnt = 0
max_result = ''
min_result = ''

for i in mk:
    if i == 'M':
        m_cnt += 1
    elif i == 'K':
        if m_cnt > 0:
            max_result += '5' + '0' * m_cnt
            min_result += '1' + '0' * (m_cnt - 1) + '5'
        else:
            max_result += '5'
            min_result += '5'
        m_cnt = 0

if m_cnt > 0:
    max_result += '1' * m_cnt
    min_result += '1' + '0' * (m_cnt - 1)

print(max_result)
print(min_result)
