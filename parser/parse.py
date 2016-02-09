#parse.py
#parses the longass list for you

#if you have to add more gates, just append them in order to the list
gates = ['s1','s0','d0','d1','d2','d3','o']
LIST_LEN = len(gates)

res = []

#change your input filename here if you want to call it something else
INPUT_FILE = "input.txt"

#open the file
with open(INPUT_FILE) as f:
    content = f.readlines()

#this line deletes the "time s1 s0..." row, the "----" row, and the empty row in the end
#IF YOU DO NOT HAVE AN EMPTY ROW AT THE END WHEN YOU COPY PASTE, GET RID OF THE -1!!!!!!!
    #LIKE SO:
    #content = content[2:]

content = content[2:-1]

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
            print(out)

#close the file, we're done!
f.close()
