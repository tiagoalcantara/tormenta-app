package app.tormenta.apitormenta.magia

import org.slf4j.LoggerFactory
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/magias")
class MagiaController(
    val magiaRepository: MagiaRepository
) {
    @GetMapping
    @Cacheable(value = ["listaDeMagias"])
    fun list(
        @PageableDefault(page = 0, size = 10, sort = ["nivel","titulo"], direction = Sort.Direction.ASC)
        paginacao: Pageable,
        @RequestParam(defaultValue = "") titulo: String,
        @RequestParam(defaultValue = "") categoria: String,
        @RequestParam(defaultValue = "1,2,3,4,5") nivel: String,
        @RequestParam(defaultValue = "") escola: String,
        @RequestParam(defaultValue = "") execucao: String,
        @RequestParam(defaultValue = "") alcance: String,
    ): Page<MagiaResponse>{
        val nivelFormatado = nivel.split(",").map { it.toInt() }

        val filtro = Specification.where(
            MagiaSpecification.titulo(titulo)).and(
            MagiaSpecification.categoria(categoria)).and(
            MagiaSpecification.escola(escola)).and(
            MagiaSpecification.execucao(execucao)).and(
            MagiaSpecification.alcance(alcance)).and(
            MagiaSpecification.nivel(nivelFormatado))

        return MagiaResponse.converterLista(magiaRepository.findAll(filtro, paginacao))
    }
}