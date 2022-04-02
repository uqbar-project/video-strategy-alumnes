package ar.edu.unsam.algo2.alumnes

class Alumne {
    var criterioEstudio: CriterioEstudio = CriterioEstudiosa
    val notas: MutableList<Int> = mutableListOf()

    fun criterioEstudiosa() { criterioEstudio = CriterioEstudiosa }
    fun criterioVaga() { criterioEstudio = CriterioVaga }
    fun criterioHijaDelRigor() { criterioEstudio = CriterioHijaRigor() }

    fun rindioParcial(nota: Int) { notas.add(nota) }
    fun estudiaPara(parcial: Parcial) = criterioEstudio.estudiaPara(parcial, this)

    fun desaproboUltimoExamen() = notas.last() < 6
}

interface CriterioEstudio {
    fun estudiaPara(parcial: Parcial, alumne: Alumne): Boolean
}

object CriterioEstudiosa : CriterioEstudio {
    override fun estudiaPara(parcial: Parcial, alumne: Alumne) = true
}

object CriterioVaga : CriterioEstudio {
    override fun estudiaPara(parcial: Parcial, alumne: Alumne) = alumne.desaproboUltimoExamen()
}

class CriterioHijaRigor : CriterioEstudio {
    override fun estudiaPara(parcial: Parcial, alumne: Alumne) = parcial.esDificil()
}

data class Parcial(val cantidadPreguntas: Int = 10) {
    fun esDificil() = cantidadPreguntas > 5
}