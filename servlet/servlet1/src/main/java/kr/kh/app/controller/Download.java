package kr.kh.app.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;

@WebServlet("/download")
public class Download extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String uploadPath = "D:\\uploads";

	private PostService postService = new PostServiceImp();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fileName = req.getParameter("fileName");
		String filePath = uploadPath + fileName.replace('/', File.separatorChar);
		File file = new File(filePath);

		try (
				FileInputStream fis = new FileInputStream(file);
				OutputStream os = resp.getOutputStream()) {

			// 파일의 MIME 타입을 가져온다.
			/*
			 * 미디어 타입 (Multipurpose Internet Mail Extensions 또는 MIME type로도 알려져 있음)이란 문서, 파일
			 * 또는 바이트 집합의 성격과 형식을 나타냄
			 */
			String mimeType = getServletContext().getMimeType(filePath);

			// 응답 객체의 컨텐츠 타입을 설정
			resp.setContentType(mimeType != null ? mimeType : "application/octet-stream");

			// 응답 객체의 컨텐츠 길이를 설정
			resp.setContentLength((int) file.length());

			// 응답 객체 헤더에 파일명을 전달
			// 파일명 => filename="파일명"으로 만들어서 전달.
			resp.setHeader("Content-Disposition", "attachment : filename=\"" + fileName + "\"");

			byte[] buffer = new byte[1024 * 4];
			int readCount = 0;
			while ((readCount = fis.read(buffer)) != -1) {
				os.write(buffer, 0, readCount);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}