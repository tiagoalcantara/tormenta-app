package app.tormenta.apitormenta.magia

import javax.persistence.*

@Entity
@Table(name = "magias")
class Magia(
    @field:Id
    @field:GeneratedValue
    val id: Long,
    @field:Column(nullable = false)
    val titulo: String,
    @field:Column(nullable = false)
    val categoria: String,
    @field:Column(nullable = false)
    val nivel: Int,
    @field:Column(nullable = false)
    val escola: String,
    @field:Column(nullable = false)
    val execucao: String,
    @field:Column(nullable = false)
    val alcance: String,
    @field:Column(nullable = false)
    val descricao: String,
    val alvo: String?,
    val duracao: String?,
    val aprimoramentos: String?,
    val resistencia: String?,
    val area: String?,
    val alvoOuArea: String?,
    val alvos: String?,
    val efeito: String?,
) {
    override fun toString(): String {
        return "Magia(id=$id, titulo='$titulo', categoria='$categoria', nivel=$nivel, escola='$escola', execucao='$execucao', alcance='$alcance', descricao='$descricao', alvo=$alvo, duracao=$duracao, aprimoramentos=$aprimoramentos, resistencia=$resistencia, area=$area, alvoOuArea=$alvoOuArea, alvos=$alvos, efeito=$efeito)"
    }
}