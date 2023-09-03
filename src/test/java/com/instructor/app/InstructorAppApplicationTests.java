package com.instructor.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.test.web.servlet.MockMvc;

import com.instructor.app.controller.InstructorController;




@WebMvcTest(InstructorController.class)
@SpringBootTest
class InstructorAppApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void whenConverterNotFound_thenThrowException() throws Exception {
		String url = "/api/list";

		this.mockMvc.perform(get(url)).andExpect(status().isInternalServerError()).andExpect(
				result -> assertThat(result.getResolvedException()).isInstanceOf(HttpMessageNotWritableException.class))
				.andExpect(result -> assertThat(result.getResolvedException().getMessage()).contains(
						"No converter for [class com.baeldung.boot.noconverterfound.model.Student] with preset Content-Type"));
	}


}
