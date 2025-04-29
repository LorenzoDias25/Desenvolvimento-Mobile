class pessoa (val nome: String, var idade: Int){ // Tarefa 1
    
    fun saudacao(){
        println("Olá, meu nome é: $nome e eu tenho $idade anos")
    }
    
    fun votar(){
        val b = if (idade >= 16) true else false
        println(b)
    }
        
}
    
fun main(args: Array<String>){//tarefas 2,3,4,5,6
    var n1 = 19
    var n2 = 2.0
    val nome = "Lorenzo"
    val msg: String
    
    val p1 = pessoa(nome, n1)
    

    
    if (n1 < 18){
        msg = "\nMenor de idade"
    } else {
        msg = "\nMaior de idade"
    }
    
    p1.saudacao()
    
    print("\nPode votar: ")
    
    p1.votar()
    
    println(msg)
    
    print("\nFor: ")
    
    for (n1 in 0..10){
        print("$n1 - ")
    }
    
    n2 = n1.toDouble()
    
    print("\n\nn2: $n2")
}
