import kotlin.random.Random

fun main(){
    var num = Random.nextInt(0, 101)
    var aux = 0
    do {
        println("Teste adivinhar o numero entre 0 e 100: ")
        aux = readLine()?.toIntOrNull() ?: 0
        if (aux > num){
            println("Mais baixo")
        } else if(num > aux) {
            println("Mais alto")
        } else {
            println("Acertou")
        }
    } while(aux != num)
}
