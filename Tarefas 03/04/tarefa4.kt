class Carro(val modelo: String, val marca: String, val ano: Int){

    fun descricao ():String{
        return "Descrição do carro: \nModelo: $modelo\nMarca: $marca\nAno: $ano"
    }
}
fun main(){
    println("Modelo do carro: ")
    val modelo = readLine() ?: ""
    println("Marca do carro: ")
    val marca = readLine()?: ""
    println("Ano: ")
    val ano = readLine()?.toIntOrNull() ?: 0

    val carro = Carro(modelo,marca,ano)

    println(carro.descricao())
}
