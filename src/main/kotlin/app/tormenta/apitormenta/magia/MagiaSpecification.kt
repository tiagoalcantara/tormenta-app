package app.tormenta.apitormenta.magia

import org.springframework.data.jpa.domain.Specification


class MagiaSpecification {
    companion object {
        fun titulo(titulo: String?): Specification<Magia?> =
            Specification<Magia?> { root, _, criteriaBuilder -> criteriaBuilder.like(criteriaBuilder.lower(root.get("titulo")), "%${titulo?.toLowerCase()}%")}

        fun categoria(categoria: String?): Specification<Magia?> =
            Specification<Magia?> { root, _, criteriaBuilder -> criteriaBuilder.like(criteriaBuilder.lower(root.get("categoria")), "%${categoria?.toLowerCase()}%")}

        fun nivel(nivel: List<Int>?): Specification<Magia?> =
            Specification<Magia?> { root, _, _ -> root.get<Int>("nivel").`in`(nivel) }

        fun escola(escola: String?): Specification<Magia?> =
            Specification<Magia?> { root, _, criteriaBuilder -> criteriaBuilder.like(criteriaBuilder.lower(root.get("escola")), "%${escola?.toLowerCase()}%")}

        fun execucao(execucao: String?): Specification<Magia?> =
            Specification<Magia?> { root, _, criteriaBuilder -> criteriaBuilder.like(criteriaBuilder.lower(root.get("execucao")),"%${execucao?.toLowerCase()}%")}

        fun alcance(alcance: String?): Specification<Magia?> =
            Specification<Magia?> { root, _, criteriaBuilder -> criteriaBuilder.like(criteriaBuilder.lower(root.get("alcance")),"%${alcance?.toLowerCase()}%")}
    }
}