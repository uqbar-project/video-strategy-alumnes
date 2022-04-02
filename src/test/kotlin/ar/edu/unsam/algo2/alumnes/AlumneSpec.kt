package ar.edu.unsam.algo2.alumnes

import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class AlumneSpec : DescribeSpec({
    isolationMode = IsolationMode.InstancePerTest
    describe("Test alumnes") {
        describe("Dada una persona estudiosa") {
            val estudiosa = Alumne().apply {
                criterioEstudiosa()
            }
            val parcial = Parcial()
            it("siempre estudia para un parcial") {
                estudiosa.estudiaPara(parcial) shouldBe true
            }
        }
        describe("Dada una persona vaga") {
            val vaga = Alumne().apply {
                criterioVaga()
            }
            val parcial = Parcial()
            it("no estudia si le fue bien la última vez") {
                vaga.rindioParcial(2)
                vaga.rindioParcial(7)
                vaga.estudiaPara(parcial) shouldBe false
            }
            it("estudia si no le fue bien la última vez") {
                vaga.rindioParcial(7)
                vaga.rindioParcial(2)
                vaga.estudiaPara(parcial) shouldBe true
            }
        }
        describe("Dada una persona hija del rigor") {
            val hijaDelRigor = Alumne().apply {
                criterioHijaDelRigor()
            }
            it("no estudia si el parcial es fácil") {
                val parcialFacil = Parcial(cantidadPreguntas = 5)
                hijaDelRigor.estudiaPara(parcialFacil) shouldBe false
            }
            it("estudia si el parcial es difícil") {
                val parcialDificil = Parcial(cantidadPreguntas = 6)
                hijaDelRigor.estudiaPara(parcialDificil) shouldBe true
            }
        }
    }
})

