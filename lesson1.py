stack = []
result = []
stringlist = []
finishone = ''
print('Исходное выражение задается в коде в переменной x')
x = '(6+9-5)/(8+1*2)+7'
print('Исходное выражение: '+x)
chardigit = ''
#Распознаём многоразрядные числа в строке
for char in x: 
    if char.isdigit():
        chardigit=chardigit+char  
    else:
        if chardigit != '':
            stringlist.append(chardigit)
        stringlist.append(char)
        chardigit = ''
if chardigit != '':
    stringlist.append(chardigit)

#Перебираем элементы строки (символы и числа)
iter=0
while iter < len(stringlist):
    #print(str(stringlist[iter]) + ' -- ' )
    #print(stack)
    #Если это число - добавляем к результату
    if stringlist[iter].isdigit():
        result.append(stringlist[iter])
    #Если это оСкобка, то добавляем в стек
    if stringlist[iter] == '(':
        stack.append(stringlist[iter])
    #Если это заСкобка, то переносим содержимое стека до оСкобки в обратном порядке
    if stringlist[iter] == ')':
        iter3 = len(stack)
        while iter3 > 0:
            iter3 -= 1
            if stack[iter3] == '(':
                break
            result.append(stack[iter3])

        #И удаляем стек до оСкобки включительно
        iter2=len(stack)
        while iter2  > 0:
            iter2-=1
            if stack[iter2] == '(':
                del stack[iter2]
                break
            del stack[iter2]
    #Если это операция *\+-
    if stringlist[iter] == '*' or stringlist[iter] == '/' or stringlist[iter] == '+' or stringlist[iter] == '-':
        #Перебираем стек до оСкобки при её наличии
        iter2=len(stack)
        checkstack = 'None'
        #Проверяем последнюю операцию в стеке
        while iter2  > 0:
            iter2-=1
            if stack[iter2] == '(':
                #По умолчанию будет checkstack = 'none' если операций нет в стеке от оСкобки
                break
            #Если последний символ стека приоритетнее текущего
            if (stack[iter2] == '*' or stack[iter2] == '/') and (stringlist[iter] == '+' or stringlist[iter] == '-'):
                checkstack = 'StackPriority'
                break
            if (stack[iter2] == '+' or stack[iter2] == '-') and (stringlist[iter] == '/' or stringlist[iter] == '*'):
                checkstack = 'CurrentPriority'
                break
            if (stack[iter2] == '+' or stack[iter2] == '-') and (stringlist[iter] == '+' or stringlist[iter] == '-') or (stack[iter2] == '*' or stack[iter2] == '/') and (stringlist[iter] == '/' or stringlist[iter] == '*'):
                checkstack = 'Equality'
                break
        if checkstack == 'None' or checkstack == 'CurrentPriority':
            #Если нет операции в стеке или последняя операция более приоритетная, чем текущая, то добавляем в стек
            stack.append(stringlist[iter])
        if checkstack == 'Equality' or checkstack == 'StackPriority':
            #Если последняя операция в стеке менее приоритетная, чем текущая или операции равноправны, то переносим стек в обратном порядке до оскобки
            iter3 = len(stack)
            while iter3 > 0:
                iter3 -= 1
                if stack[iter3] == '(':
                    break
                result.append(stack[iter3])
            #И удаляем стек до оСкобки не включительно
            iter2=len(stack)
            while iter2  > 0:
                iter2-=1
                if stack[iter2] == '(':
                    break
                del stack[iter2]
            #и помещаем в стек новый символ
            stack.append(stringlist[iter])
    iter+=1
# Если конец выражения, переносим остаток стека в результат            
iter3 = len(stack)
while iter3 > 0:
    iter3 -= 1
    result.append(stack[iter3])



#print(result)

for x in result:
    finishone = finishone + str(x)

print('Преобразование в ОПН: '+finishone)

#================================================================================================

result2 = []
stack = []
iter=0
while iter < len(result):
    #print(str(stringlist[iter]) + ' -- ' )
    
    #Если это число - добавляем к результату
    if result[iter].isdigit():
        stack.append(result[iter])
    if result[iter] == '*' or result[iter] == '/' or result[iter] == '+' or result[iter] == '-':

        iter3 = len(stack)
        while iter3 > 0:
            iter3 -= 1
            if iter3 == len(stack)-1:
                y = float(stack[iter3])
            elif iter3 == len(stack)-2:
                x = float(stack[iter3])
            else:
                break
        #print('x:'+ str(x))
        #print('y:'+ str(y))  

        del stack[len(stack)-2]  
        del stack[len(stack)-1]   

        if result[iter] == '*':
            stack.append(x*y)
        if result[iter] == '/':
            stack.append(x/y)
        if result[iter] == '+':
            stack.append(x+y)
        if result[iter] == '-':
            stack.append(x-y)
        #print(stack)
        
   
    iter+=1

print('Результат вычисления ОПН: '+str(stack[0]))
