
fun main(){
    
    val operations = arrayOf("+","/","*","-","-")
    val uppriority = arrayOf("*","/")
    val lowpriority = arrayOf("+","-")
    //var opnresult: String
    val w : String = "(6+999-5)/(8+1*2)+7"
    println(w)
    var checkstack: String
    
    //Распознаём многоразрядные числа в строке
    fun bigdigit(str: String) :MutableList<String>
    {
        var chardigit: String = ""
        val locallist : MutableList<String> = mutableListOf() 
        for(char in str){
            if (char.isDigit()) {
                chardigit=chardigit+char 
            } else {
                if (chardigit != "") {
                    locallist.add(chardigit)
                }
                locallist.add(char.toString())
                chardigit = ""
            }
        }
        if (chardigit != ""){
            locallist.add(chardigit)
        }
        return locallist
    }
    fun opn(stringlist:MutableList<String>) :MutableList<String>
    {
        val stack : MutableList<String> = mutableListOf()
        val result : MutableList<String> = mutableListOf()
        
        var iter: Int = 0
        var iter2: Int
        var iter3: Int
        var finishone: String = ""
        while (iter < stringlist.count()){
            if (stringlist[iter].all { Character.isDigit(it) }){
                result.add(stringlist[iter])
            }
            if (stringlist[iter] == "("){
                stack.add(stringlist[iter])
            }
            if (stringlist[iter] == ")") {
                iter3 = stack.count()
                while (iter3 > 0) {
                    iter3=iter3-1
                    if (stack[iter3] == "("){
                        break
                    }
                    result.add(stack[iter3])
                }
                iter2=stack.count()
                while (iter2  > 0) {
                    iter2=iter2-1
                    if (stack[iter2] == "(") {
                        stack.removeAt(iter2)
                        break
                    }
                    stack.removeAt(iter2)
                }
            }

//---------------------------------------------

            if (stringlist[iter] in operations) 
            {
                iter2=stack.count()
                checkstack = "None"
                while (iter2  > 0){
                    iter2=iter2-1
                    if (stack[iter2] == "(") {
                        break 
                    }    
                    if ((stack[iter2] in uppriority) and (stringlist[iter] in lowpriority)){
                        checkstack = "StackPriority"
                        break
                    }
                    if ((stack[iter2] in lowpriority) and (stringlist[iter] in uppriority)) {
                        checkstack = "CurrentPriority"
                        break
                    }
                    if (((stack[iter2] in lowpriority) and (stringlist[iter] in lowpriority)) or ((stack[iter2] in uppriority) and (stringlist[iter] in uppriority))){
                        checkstack = "Equality"
                        break
                    }
                }

                if ((checkstack == "None") or (checkstack == "CurrentPriority")) {
                    stack.add(stringlist[iter])
                }
                    
                if ((checkstack == "Equality") or (checkstack == "StackPriority")) {
                    iter3 = stack.count()
                    while (iter3 > 0) {
                        iter3 = iter3-1
                        if (stack[iter3] == "("){
                            break
                        }
                        result.add(stack[iter3])
                    }
                    iter2=stack.count()
                    while (iter2  > 0) {
                        iter2= iter2-1
                        if (stack[iter2] == "("){
                            break
                        }
                        stack.removeAt(iter2)
                    }
                    stack.add(stringlist[iter]) 
                }
            }
//---------------------------------------------
            iter=iter+1
        }        
        iter3 = stack.count()
        while (iter3 > 0){
            iter3 = iter3-1
            result.add(stack[iter3])
        }
        for (xxx in result){
            finishone = finishone + xxx.toString()
        }
        println (finishone)
        return result
    }
    
//-------------------------------------------------------------

    fun calc(result:MutableList<String>):String {
        val stack : MutableList<String> = mutableListOf()
        var iter: Int = 0
        var iter3: Int
        var x: Float=0.00f
        var y: Float=0.00f
        while (iter < result.count()) {
            
            if (result[iter].all { Character.isDigit(it) }) {
                stack.add(result[iter])
            }
                
            if (result[iter] in operations) {
                iter3 = stack.count()
                while (iter3 > 0) {
                    iter3 = iter3 - 1
                    if (iter3 == stack.count()-1){
                        y = stack[iter3].toFloat()
                    }
                    else{
                        if (iter3 == stack.count()-2){
                            x = stack[iter3].toFloat()
                        }
                        else{
                            break 
                        } 
                    }                   

                }
                    
                stack.removeAt(stack.count()-2)
                stack.removeAt(stack.count()-1)

                if (result[iter] == "*"){
                    stack.add((x*y).toString())
                }
                if (result[iter] == "/"){
                    stack.add((x/y).toString())
                }
                if (result[iter] == "+"){
                    stack.add((x+y).toString())
                }
                if (result[iter] == "-"){
                    stack.add((x-y).toString())
                } 
            }
                
            iter=iter+1
        }
        return stack[0]
    }


    //println(bigdigit(w))
    //println(opn(bigdigit(w)))
    //println(calc(opn(bigdigit(w))))


    var lambda_demo = {calc(opn(bigdigit(w)))}
    println(lambda_demo())
 

 



}