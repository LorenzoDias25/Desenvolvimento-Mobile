fun main(){
    println("Digite o nome para testar se é palindromo: ")
    var msg = readLine() ?: ""
    msg = msg.lowercase()
    var msg2 = ""
    val vetor = msg.toCharArray()
    val vetor2 = Array<Char>(msg.length){' '}
    var cont = msg.length - 1
    while (cont >= 0){
        msg2 += vetor[cont]
        cont--
    }
    if(msg.equals(msg2)){
        println("A palavra: $msg é um palindromo")
    } else {
        println("A palavra $msg não é um palindromo")
    }
}
