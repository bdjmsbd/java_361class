package kr.kh.app.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Part;

import org.apache.jasper.tagplugins.jstl.core.Out;

public class FileUploadUtils {

	// Part 객체서 파일명을 가져오는 메소드
	public static String getFileName(Part part) {
		String contentDisposition = part.getHeader("content-disposition");
//	String [] items = contentDisposition.split(";");
		List<String> items = Arrays.asList(contentDisposition.split(";"));
		for (String item : items) {
			System.out.println(item);
			// 속성명= 값;
			if (item.trim().startsWith("filename")) {
				return item.substring(item.indexOf("=") + 2, item.length() - 1);
			}
		}
		return null;
	}

	// uploadPath를 기준으로 paths 폴더들을 생성해주는 메소드
	// 한 폴더에 첨부파일을 다 업로드하면 서버의 성능이 떨어진다.
	public static void makeDir(String uploadPath, String... paths) {
		int lastIndex = paths.length - 1;
		/*
		 * if(lastIndex == -1) { return; }
		 */

		if (new File(uploadPath + paths[lastIndex]).exists()) {
			return;
		}

		for (String path : paths) {
			File dir = new File(uploadPath + path);
			if (!dir.exists()) {
				dir.mkdir();
			}
		}

	}

	// uploadPath를 기준으로 년/월/일 폴더를 만들어서 경로를 반환하는 메소드
	// 성능 저하 이슈로 일 단위로 구분해서 새로 생성해준다.
	public static String calculatePath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		String yearPath = File.separator + cal.get(Calendar.YEAR);

		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);

		String dayPath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));

		makeDir(uploadPath, yearPath, monthPath, dayPath);

		return dayPath;
	}

	public static String upload(String uploadPath, Part file) {

		String fileName = getFileName(file);

		// uuid를 생성. 8-4-4-4-12와 같은.
		UUID uuid = UUID.randomUUID();
		String filePath = calculatePath(uploadPath) + File.separator + uuid + "_" + fileName;

		try (OutputStream os = new FileOutputStream(uploadPath + filePath)) {
			InputStream is = file.getInputStream();

			byte[] buffer = new byte[1024 * 4];
			int readCount = 0;

			while ((readCount = is.read(buffer)) != -1) {
				os.write(buffer);
			}

			return filePath.replace(File.separatorChar, '/');
		}

		catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
