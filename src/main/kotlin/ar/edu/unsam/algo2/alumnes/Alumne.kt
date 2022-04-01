package ar.edu.unsam.algo2.alumnes

class Alumne {
    var criterioEstudio: Int = 1
    val notas: MutableList<Int> = mutableListOf()

    fun criterioEstudiosa() { criterioEstudio = 1 }
    fun criterioVaga() { criterioEstudio = 2 }
    fun criterioHijaDelRigor() { criterioEstudio = 3 }

    fun rindioParcial(nota: Int) { notas.add(nota) }
    fun estudiaPara(parcial: Parcial) =
        when (criterioEstudio) {
            // ESTUDIOSA
            1 -> true

            // VAGA
            2 -> notas.last() < 6

            // HIJA DEL RIGOR
            3 -> parcial.cantidadPreguntas > 5

            else -> false
        }

}

data class Parcial(val cantidadPreguntas: Int = 10)