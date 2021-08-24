import sqlite3

conn = sqlite3.connect('orgdb.sqlite')
cur = conn.cursor()

#cur.execute('DROP TABLE IF EXISTS Counts')

#cur.execute('''
#CREATE TABLE Counts (org TEXT UNIQUE, count INTEGER)''')

# Extract data into a dictionarie
org_count = dict()
fname = input('Enter file name: ')
if (len(fname) < 1): fname = 'mbox.txt'
fh = open(fname)
for line in fh:
    if not line.startswith('From: '): 
        continue
    pieces = line.split()
    org = pieces[1].split("@")
    org_count[org[1]] = org_count.get(org[1], 0) + 1


for key, value in org_count.items():
    cur.execute("""INSERT INTO Counts (org, count) VALUES (?, ?)""", (key, value))

# Record on DB
conn.commit()
sqlstr = 'SELECT org, count FROM Counts ORDER BY count DESC LIMIT 5'

for row in cur.execute(sqlstr):
    print(str(row[0]), row[1])

cur.close()
