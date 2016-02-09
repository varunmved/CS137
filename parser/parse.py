#parse.py
#parses the longass list for you

res = []

#change your input filename here if you want to call it something else
INPUT_FILE = "input.txt"

#open the file
with open(INPUT_FILE) as f:
    content = f.readlines()

#get the name of the gates/input/outputs we care about
gates = content[0].split()
gates = gates[1:]
LIST_LEN = len(gates)

#delete the first two rows (name + '-----')
content = content[2:]

#if you have an empty row in the end of your file, it'll delete it for you
if content[-1] == '\n':
    content = content[:-1]

#parse through the lines
for line in content:
    #delimit by spaces
    a = line.split()

    #get rid of time since we don't use it
    a = a[1:]
    
    #create an emtpy string to ouptut
    out =  ""
    
    #iterate through the gate values in the gate list, and the raw values from the text file
    for i in range(0,LIST_LEN):
        
        #build our string
        out += gates[i]+ "= " + a[i] + "; "

        #on the last line, add an empty line for readability 
        if i == LIST_LEN-1:
            out+='\n'
            res.append(out)
            #print(out)

#close the file, we're done!
f.close()
