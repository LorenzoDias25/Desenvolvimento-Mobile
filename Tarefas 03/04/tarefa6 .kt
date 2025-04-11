fun main(){
    var lista = mutableListOf<Double>()
    var aux = 0.0
    do {
        println("Digite numeros par adicionar a média ou 0 para sair")
        aux = readLine()?.toDoubleOrNull() ?:  0.0
        if (aux != 0.0) {
            lista.add(aux)
        }

    } while( aux != 0.0)
    println("Numeros: " + lista + "Média: " + media(lista))
}

fun media(num: List<Double>): Double{

    return if(num.isEmpty()){
        0.0
    } else {
        num.sum() / num.size
    }
}
