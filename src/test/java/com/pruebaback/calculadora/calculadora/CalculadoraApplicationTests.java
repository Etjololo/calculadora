package com.pruebaback.calculadora.calculadora;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CalculadoraApplicationTests {

	private static final String BASE_URL = "/api/calculadora";
	private Long parametro1 = 1L;
	private Long parametro2 = 2L;
	private String parametro3 = "";

	@Autowired
	private MockMvc mvc;

	@Test
	public void sumaTestOK_200() throws Exception {
		mvc.perform(get(BASE_URL + "/suma/"+parametro1+"+"+parametro2))
				.andExpect(status().isOk())
				.andExpect(content().json(String.valueOf(3)));
	}

	@Test
	public void restaTestOK_200() throws Exception {
		mvc.perform(get(BASE_URL + "/resta/"+parametro1+"-"+parametro2))
				.andExpect(status().isOk())
				.andExpect(content().json(String.valueOf(-1)));
	}

	@Test
	public void sumaTest_400_UnParametro() throws Exception {
		mvc.perform(get(BASE_URL + "/suma/"+parametro1+"+"+parametro3))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void sumaTest_400_DosParametros() throws Exception {
		mvc.perform(get(BASE_URL + "/suma/"+parametro3+"+"+parametro3))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void restaTest_400_UnParametro() throws Exception {
		mvc.perform(get(BASE_URL + "/resta/"+parametro1+"-"+parametro3))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void restaTest_400_DosParametros() throws Exception {
		mvc.perform(get(BASE_URL + "/resta/"+parametro3+"-"+parametro3))
				.andExpect(status().isBadRequest());
	}

}
