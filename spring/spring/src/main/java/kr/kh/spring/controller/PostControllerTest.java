package kr.kh.spring.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

/* 
 * import 할 때 junit Before로 
 * java 파일 우클릭 run as -> junit
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
		locations={
				"file:src/main/webapp/WEB-INF/spring/root-context.xml",
				"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
				"file:src/main/webapp/WEB-INF/spring/spring-security.xml"})
@Log4j
public class PostControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		//테스트 전 MockMvc 객체 생성
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

//	@Test
//	public void test() {
//		try {
//			mockMvc.perform(get("/테스트할 url")
//					.param("파라미터명", "값")
//					.param("파라미터명", "값"))
//					.andDo(print())
//					.andExpect(status().isOk());
//		} catch (Exception e) {
//			log.error(e.getMessage());
//		}
//	}

	@Test
	public void test() {
		try {
			mockMvc.perform(get("/post/list")
					.param("page", "1")
					.param("co_num", "1"))
					.andDo(print())
					.andExpect(status().isOk());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
}
