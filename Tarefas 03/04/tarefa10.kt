class Estudante(val nome:String, val idade:Int, val lista: List<Double>){

}

fun main(){
    println("Digite os dados do estudante ")
    println("Nome do estudante: ")
    val nome = readLine()?: ""
    println("idade: ")
    val idade = readLine()?.toIntOrNull()?: 0
    val lista = mutableListOf<Double>()

    var aux = 0.0
    do{
        println("Digite as notas ou 0 para sair: ")
        aux = readLine()?.toDoubleOrNull()?: 0.0
        if(aux != 0.0){
            lista.add(aux)
        }
    }while(aux != 0.0)

    val estu = Estudante(nome, idade,lista)
    if(media(lista) >= 7.0){
        println("Nome: " + estu.nome)
        println("Idade: " + estu.idade)
        println("Notas: " + estu.lista)
        println("Média: " + media(lista))
        println("Aprovado")
    } else {
        println("Reprovado")
    }
}

fun media(num: List<Double>):Double{
    return num.sum() / num.size
}
