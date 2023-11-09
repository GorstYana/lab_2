fun main(args: Array<String>) {
    //1 задание
println("Введите имя пользователя: ")
    val n = readln()
    println("Введите время в секундах: ")
    val s = readln().toInt()
    println("$n был(а) в сети " + agoToText(s))
    println(" ")
    main22()
}
fun agoToText(a:Int): String{
    when(a){
        in 0..60 -> return("только что.")
        in 61..60*60 -> return(min(a/60))
        in 60*60+1..24*60*60 -> return(hour(a/(60*60)))
        in 24*60*60+1..24*2*60*60 -> return("вчера.")
        in 24*2*60*60+1..24*3*60*60 -> return("позавчера.")
    }
    return("давно.")
}
fun min(a: Int): String{
    when(a){
        in 11..14 -> return("$a минут назад.")
    }
    when(a%10){
        1 -> return("$a минуту назад.")
        in 2..4 -> return("$a минуты назад.")
    }
    return("$a минут назад.")
}
fun hour(a: Int): String{
    when(a){
        in 11..14 -> return("$a часов назад.")
    }
    when(a%10){
        1 -> return("$a час назад.")
        in 2..4 -> return("$a часа назад.")
    }
    return("$a часов назад.")
}
fun main22() {
    //2 задание
    println("Введите тип карты")
    val d = readln()
    println("Введите сумму предыдущих переводов")
    val k = readln().toInt()
    println("Введите сумму текущего перевода")
    val n = readln().toInt()
    println("Комиссия перевода с карты $d составляет: "+ komissia(d, n, k))
}
fun komissia (a:String = "VKPay", b:Int = 0, c:Int) : String{
    when(a){
        "Mastercard" , "Maestro" -> if(c<=150000 && b+c<=600000){
            if(b+c<75000) return ("0 рублей") else return ( ""+c*0.006+20+" рублей")
        }
        else return ("Сумма переводов превысила лимит.")
        "Visa" , "Мир" -> if(c<=150000 && b+c<=600000){
            if(c<35) return ("0 рублей") else return ("" + c*0.0075 + " рублей")
        }
        else return ("Сумма переводов превысила лимит.")
        "VKPay" -> if(b+c<=40000 && c<=15000) return ("0 рублей") else return("Превышен лимит переводов")
    }
    return("Неизвестная карта.")
}