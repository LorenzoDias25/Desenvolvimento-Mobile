fun main(){
    var vetor = Array<Int>(10){0}
    println("Digite o primeiro numero da sequencia de fibonacci")
    vetor[0] = readLine()?.toIntOrNull()?: 0
    println("Digite o segundo numero da sequencia de fibonacci")
    vetor[1] = readLine()?.toIntOrNull()?: 0
    println(fibo(vetor))
}

fun fibo(vetor: Array<Int>): String{
    var cont = 2
    var msg = ""
    while(cont < vetor.size){
        vetor[cont] = vetor[cont - 1] + vetor[cont - 2]
        cont++
    }
    for(i in 0..vetor.size - 1){
        msg += vetor[i]
        msg += " - "
    }
    return msg
}
