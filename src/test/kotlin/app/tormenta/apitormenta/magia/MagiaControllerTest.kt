package app.tormenta.apitormenta.magia

import com.fasterxml.jackson.databind.ObjectMapper
import org.hamcrest.Matchers
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
internal class MagiaControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var repository: MagiaRepository

    val listMagias = listOf<Magia>(
        Magia(1, "Magia B", "Categoria A", 1, "Escola A", "Execução A", "Alcance A", "Descrição A", "Alvo A", "Duração A", "Aprimoramentos A", "Resistência A", "Area A", "Alvo ou Area A", "Alvos A", "Efeito A"),
        Magia(2, "Magia B", "Categoria A", 1, "Escola A", "Execução A", "Alcance A", "Descrição A", "Alvo A", "Duração A", "Aprimoramentos A", "Resistência A", "Area A", "Alvo ou Area A", "Alvos A", "Efeito A"),
        Magia(3, "Magia B", "Categoria A", 2, "Escola A", "Execução A", "Alcance A", "Descrição A", "Alvo A", "Duração A", "Aprimoramentos A", "Resistência A", "Area A", "Alvo ou Area A", "Alvos A", "Efeito A"),
        Magia(4, "Magia A", "Categoria A", 3, "Escola A", "Execução A", "Alcance A", "Descrição A", "Alvo A", "Duração A", "Aprimoramentos A", "Resistência A", "Area A", "Alvo ou Area A", "Alvos A", "Efeito A"),
        Magia(5, "Magia A", "Categoria A", 4, "Escola A", "Execução A", "Alcance A", "Descrição A", "Alvo A", "Duração A", "Aprimoramentos A", "Resistência A", "Area A", "Alvo ou Area A", "Alvos A", "Efeito A"),
        Magia(6, "Magia A", "Categoria A", 5, "Escola A", "Execução A", "Alcance A", "Descrição A", "Alvo A", "Duração A", "Aprimoramentos A", "Resistência A", "Area A", "Alvo ou Area A", "Alvos A", "Efeito A"),
    )

    @BeforeEach
    fun init() { repository.saveAll(listMagias) }

    @AfterEach
    fun clean(){ repository.deleteAll() }

    @Test
    fun `Deve listar todas as magias`(){
        mockMvc.get("/magias")
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$.totalElements", Matchers.equalTo(listMagias.size))
            }
    }

    @Test
    fun `Deve filtrar magias de acordo com os parametros da url`(){
        val filteredList = listMagias.filter {
            it.nivel <= 2 &&
            it.titulo.contains("Magia B") &&
            it.escola.contains("Escola A") &&
            it.alcance.contains("Alcance A") &&
            it.categoria.contains("Categoria A") &&
            it.execucao.contains("Execução A")
        }

        mockMvc.get("/magias?nivel=1,2&titulo=Magia B&alcance=Alcance A&categoria=Categoria A&execucao=Execução A")
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$.totalElements", Matchers.equalTo(filteredList.size))
            }
    }
}