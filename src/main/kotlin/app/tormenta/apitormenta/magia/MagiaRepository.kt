package app.tormenta.apitormenta.magia

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface MagiaRepository: JpaRepository<Magia, Long>, JpaSpecificationExecutor<Magia> {}

