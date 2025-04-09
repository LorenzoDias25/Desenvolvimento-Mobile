fun main(){
    val msg = "lorenzo"
    val vetor = msg.toCharArray()
    val vetor2: Array<Char?> = arrayOfNulls(msg.length)
    var cont = msg.length - 1
    var aux = 0
    while (cont > 0){
        vetor2[aux] = vetor[cont] 
        cont--
        aux++
    }
    aux = 0
    while(aux < (msg.length - 1)){
        print(vetor[aux] + " - ")
    }
    println()
    /*while(aux < msg.length){
        print(vetor2[aux] + " - ")
    }*/
}
