'''
If you have to add more gates, just append them in order to the list
'''
gates = ['s1','s0','d0','d1','d2','d3','o']
LIST_LEN = len(gates)

with open("input.txt") as f:
    content = f.readlines()


res = []

content = content[:-1]
for line in content:
    #delimit by spaces
    a = line.split()

    #get rid of time since we don't use it
    a = a[1:]
    
    out =  ""
    
    for i in range(0,LIST_LEN):
        out += gates[i]+ "= " + a[i] + "; "
        if i == LIST_LEN-1:
            out+='\n'
            res.append(out)
        
            #uncomment the next line if you want to test outputs 
            print(out)
f.close()
