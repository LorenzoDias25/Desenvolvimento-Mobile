import kotlin.random.Random

fun main(){
    
    val op = 4//Random.nextInt(1,5) // gera um numero aleatorio entre 0 e 5
    
    when (op) {
        1 -> {
            val n1 = Random.nextInt(0,101) 
            val n2 = Random.nextInt(0,101)
            println("A soma de $n1 + $n2 é: " + (n1+n2));
        }
        2-> {
            val n1 = Random.nextInt(0,101) 
            val n2 = Random.nextInt(0,101)
            println("A subtração de $n1 - $n2 é: " + (n1-n2))
        }
        3-> {
            val n1 = Random.nextInt(0,101) 
            val n2 = Random.nextInt(0,101)
            println("A multiplicação de $n1 * $n2 é: " + (n1*n2))
        }
        4 -> {
            val n1 = Random.nextInt(0,101) 
            val n2 = Random.nextInt(0,101)
            println("A divisão de $n1 / $n2 é: " + (n1.toDouble()/n2.toDouble()))
        }
    }
}
