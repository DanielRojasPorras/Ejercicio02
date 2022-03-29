
class Serie : Entregable{
    var titulo : String = ""
    var num_temporadas : Int = 3
    var entregado : Boolean = false
    var genero : String = ""
    var creador : String = ""

    constructor(titulo: String, creador: String){
        this.titulo = titulo
        this.creador = creador
    }
    constructor(titulo : String, num_temporadas : Int, genero : String , creador : String){
        this.titulo = titulo
        this.num_temporadas = num_temporadas
        this.genero = genero
        this.creador = creador
    }
    constructor()

    override fun entregar() {
        this.entregado = true
    }

    override fun devolver() {
        this.entregado = false
    }

    override fun isEntregado(): Boolean {
        return this.entregado
    }

}
class VideoJuego : Entregable{

    var titulo : String = ""
    var horas_estimadas : Int = 10
    var entregado : Boolean = false
    var genero : String = ""
    var compannia : String = ""

    constructor(titulo: String, horas_estimadas : Int){
        this.titulo = titulo
        this.horas_estimadas = horas_estimadas
    }
    constructor(titulo: String,horas_estimadas: Int, genero: String, compannia : String){
        this.titulo = titulo
        this.horas_estimadas = horas_estimadas
        this.genero = genero
        this.compannia = compannia
    }

    override fun entregar() {
        this.entregado = true
    }

    override fun devolver() {
        this.entregado = false
    }

    override fun isEntregado(): Boolean {
        return this.entregado
    }
}
interface Entregable{
   fun entregar()
   fun devolver()
   fun isEntregado():  Boolean
}

fun main(args: Array<String>) {
    var Series = arrayOf<Serie>()
    var videoJuegos = arrayOf<VideoJuego>()

    val serie1 = Serie("Hawkeye","Marvel")
    val serie2 = Serie("Breaking Bad",5,"Crimen","George Vincent Gilligan, Jr")
    val serie3 = Serie("Desencanto",4,"Comedia Animada","Matt Groening")
    val serie4 = Serie("Loki","Marvel")
    val serie5 = Serie("Los Simpson",33,"Comedia Animada","Matt Groening")

    Series = Series.plus(serie1)
    Series = Series.plus(serie2)
    Series = Series.plus(serie3)
    Series = Series.plus(serie4)
    Series = Series.plus(serie5)


    val videoJuego1 = VideoJuego("Valorant",0)
    val videoJuego2 = VideoJuego("Call of Duty",100,"Disparo Primera Accion","Infinity Ward Treyarch Sledgehammer Games")
    val videoJuego3 = VideoJuego("Clash Royale",500)
    val videoJuego4 = VideoJuego("Super Mario",400)
    val videoJuego5 = VideoJuego("Pac Man",200,"Destreza","Namco")

    videoJuegos = videoJuegos.plus(videoJuego1)
    videoJuegos = videoJuegos.plus(videoJuego2)
    videoJuegos = videoJuegos.plus(videoJuego3)
    videoJuegos = videoJuegos.plus(videoJuego4)
    videoJuegos = videoJuegos.plus(videoJuego5)

//    	Entrega algunos Videojuegos y Series con el método entregar().
    serie1.entregar()
    serie5.entregar()

    videoJuego1.entregar()
    videoJuego4.entregar()
    videoJuego3.entregar()


//    	Cuenta cuantos Series y Videojuegos hay entregados. Al contarlos, devuélvelos.
    var contSerie = 0
    for (i in Series.indices){
        if (Series[i].isEntregado()){
            contSerie++
            Series[i].devolver()
        }
    }

println("Hay " + contSerie + " series prestadas.")

    var contVideoJuego = 0
    for (i in videoJuegos.indices){
        if (videoJuegos[i].isEntregado()){
            contVideoJuego++
            videoJuegos[i].devolver()
        }
    }

    println("Hay " + contVideoJuego + " video juegos prestados.")
    println()

// para ver que se devolvieron las series y videojuegos
    for (i in Series.indices){
        println(Series[i].entregado)
    }
    println()

    for (i in videoJuegos.indices){
        println(videoJuegos[i].entregado)
    }

}