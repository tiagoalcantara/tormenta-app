package app.tormenta.apitormenta.magia

import org.springframework.data.domain.Page

data class MagiaResponse(
    val id: Long,
    val titulo: String,
    val categoria: String,
    val nivel: Int,
    val escola: String,
    val execucao: String,
    val alcance: String,
    val descricao: String,
    val alvo: String?,
    val duracao: String?,
    val aprimoramentos: String?,
    val resistencia: String?,
    val area: String?,
    val alvoOuArea: String?,
    val alvos: String?,
    val efeito: String?,
){
    constructor(magia: Magia) : this(
        magia.id,
        magia.titulo,
        magia.categoria,
        magia.nivel,
        magia.escola,
        magia.execucao,
        magia.alcance,
        magia.descricao,
        magia.alvo,
        magia.duracao,
        magia.aprimoramentos,
        magia.resistencia,
        magia.area,
        magia.alvoOuArea,
        magia.alvos,
        magia.efeito
    )

    companion object {
        fun converterLista(pageMagia: Page<Magia>) = pageMagia.map { MagiaResponse(it) }
    }
}
