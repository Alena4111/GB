class Calculator:

    operations = ["+","/","-","*"]
    uppriority = ["*","/"]
    lowpriority = ["+","-"]
    opnresult = ''

    def __init__(self, x):
        """Constructor"""
        self.x = x

    #Распознаём многоразрядные числа в строке
    def bigdigit(self):
        chardigit = ''
        locallist = []
        for char in self.x: 
            if char.isdigit():
                chardigit=chardigit+char  
            else:
                if chardigit != '':
                    locallist.append(chardigit)
                locallist.append(char)
                chardigit = ''
        if chardigit != '':
            locallist.append(chardigit)
        return locallist

    def opn(self,stringlist):
        stack = []
        result = []
        finishone = ''
        #Перебираем элементы строки (символы и числа)
        iter=0
        while iter < len(stringlist):
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
            if stringlist[iter] in self.operations:
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
                    if (stack[iter2] in self.uppriority) and (stringlist[iter] in self.lowpriority):
                        checkstack = 'StackPriority'
                        break
                    if (stack[iter2] in self.lowpriority) and (stringlist[iter] in self.uppriority):
                        checkstack = 'CurrentPriority'
                        break
                    if (stack[iter2] in self.lowpriority) and (stringlist[iter] in self.lowpriority) or (stack[iter2] in self.uppriority) and (stringlist[iter] in self.uppriority):
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
        
        for x in result:
            finishone = finishone + str(x)
        self.opnresult = finishone
        return result

    #================================================================================================
    def calc(self,result):
        stack = []
        iter=0
        while iter < len(result):
            if result[iter].isdigit():
                stack.append(result[iter])
            if result[iter] in self.operations:
                iter3 = len(stack)
                while iter3 > 0:
                    iter3 -= 1
                    if iter3 == len(stack)-1:
                        y = float(stack[iter3])
                    elif iter3 == len(stack)-2:
                        x = float(stack[iter3])
                    else:
                        break 

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
            iter+=1
        return str(stack[0])

if __name__ == "__main__":
    x = '(6+9-5)/(8+1*2)+7'
    onex = Calculator(x)
    bigdigit = onex.bigdigit()
    opn = onex.opn(bigdigit)    
    print(onex.x)
    print(onex.opnresult)
    calc = onex.calc(opn)
    print(calc)






