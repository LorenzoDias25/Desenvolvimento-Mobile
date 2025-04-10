fun main(){

    println("Digite um numero: ")
    val n = readLine()?.toIntOrNull() ?: 0
    println(teste(n))
}

fun teste( n:Int): String {

    var msg = ""
    for (x in 0..n){
        if (x % 2 != 0){
            msg += x.digitToChar() + "\n"
        }
    }

    return msg
}
