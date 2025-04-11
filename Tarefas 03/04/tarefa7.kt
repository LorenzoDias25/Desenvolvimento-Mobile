fun main(){
    println("Digite a palavra a ser testada: ")
    var msg = readLine()?: ""
    println("Numero de vogais: " + cont(msg))
}

fun cont(msg: String): Int{
    var vetor = msg.toCharArray()
    var temp = msg.length - 1
    var cont = 0
    for(aux in 0..temp){
        when(vetor[aux]){
            'A'-> cont++;
            'a'-> cont++;
            'E' -> cont++;
            'e' -> cont++;
            'I' -> cont++;
            'i' -> cont++;
            'O' -> cont++;
            'o' -> cont++;
            'U' -> cont++;
            'u' -> cont++;
        }
    }
    return cont
}
