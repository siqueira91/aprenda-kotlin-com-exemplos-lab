data class ConteudoEducacional(private val id: Long, private val nome: String, private val duracao: Double) {
    fun getId(): Long {
        return this.id
    }
    fun getNome(): String {
        return this.nome
    }
    fun getDuracao(): Double {
        return this.duracao
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ConteudoEducacional) return false
        return id == other.id
    }
}

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(private val id: Long, private val nome: String, private val cpf: String) {
    fun getId(): Long {
        return this.id
    }
    fun getNome(): String {
        return this.nome
    }
    fun getICpf(): String {
        return this.cpf
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Usuario) return false
        return id == other.id
    }
}

data class Formacao(private val descricao: String, private val conteudos: ConteudoEducacional) {

    fun getDescricao(): String {
        return this.descricao
    }

    fun getConteudos(): ConteudoEducacional {
        return this.conteudos
    }

    val inscritos = mutableListOf<Usuario>()

    fun matricular(vararg usuario: Usuario) {
        println("\nAlunos matriculados em Kotlin: ")
        for(usuario in usuario) {
            inscritos.add(usuario)
        }
    }
    fun desistir(vararg usuario: Usuario) {
        println("\nAlunos matriculados em Kotlin: ")
        for(usuario in usuario) {
            inscritos.remove(usuario)
        }
    }
}

fun main() {
    val cursos = listOf(
        ConteudoEducacional(1L, "Kotlin", 30.5),
        ConteudoEducacional(2L, "Java", 40.5),
        ConteudoEducacional(3L, "Python", 50.5)
    )
    println(cursos[0] == cursos[1]) //equals
    for(curso in cursos) {
        println(curso)
    }

    val nivelDoCursoKotlin = Nivel.INTERMEDIARIO
    val mensagemNivel = when(nivelDoCursoKotlin) {
        Nivel.BASICO -> "O curso de Kotlin é do nivel básico"
        Nivel.INTERMEDIARIO -> "O curso de Kotlin é do nivel intermediário"
        Nivel.AVANCADO -> "O curso de Kotlin é do nivel avançado"
    }
    println("\n$mensagemNivel\n")

    val usuarios = mutableListOf(
        Usuario(1L, "Marcos Souza", "00000000"),
        Usuario(2L, "Charles Pereira", "11111111"),
        Usuario(3L, "Maria Oliveira", "22222222")
    )

    println(usuarios[0] == usuarios[1]) //equals
    for(usuario in usuarios) {
        println(usuario)
    }

    val kotlinCurso: Formacao = Formacao("Kotlin Experience", cursos.first())

    kotlinCurso.matricular(usuarios[1], usuarios[0])
    val matriculados = kotlinCurso.inscritos
    matriculados.sortBy{ it.getNome() }
    for(matriculado in matriculados) {
        println (matriculado.getNome())
    }

    kotlinCurso.desistir(usuarios[1])
    for(matriculado in matriculados) {
        println (matriculado.getNome())
    }
}
