import kotlin.random.Random

fun main(){
    var cont = Random.nextInt(2,20)
    
    var fat = 1
    println("O fatorial de $cont é:")
    while(cont > 1){
        fat = fat * cont
        cont--;
    }
    print(fat)
}
