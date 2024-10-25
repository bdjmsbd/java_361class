package kr.kh.spring.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DataController {

	@GetMapping("/data/sample")
	public String dataSample() {

		return "/data/sample";
	}
	
	@GetMapping("/data/sample2")
	public String dataSample2() {

		return "/data/sample2";
	}
	
	@ResponseBody
	@PostMapping(value="/data/sample", produces="application/text; charset=UTF-8")
	public String dataSamplePost() throws Exception {
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustFrcstDspth"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=nw0ZEH7ZE1KVNJHegVOTNlO%2Fg8oCTSuadtOhhISLbMNPmbTJWCJjMx%2BLVJTpx1PqqddyxjrahpYFREVzykjEQw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*xml 또는 json*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수(조회 날짜로 검색 시 사용 안함)*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호(조회 날짜로 검색 시 사용 안함)*/
        urlBuilder.append("&" + URLEncoder.encode("searchDate","UTF-8") + "=" + URLEncoder.encode("2024-10-20", "UTF-8")); /*통보시간 검색(조회 날짜 입력이 없을 경우 한달동안 예보통보 발령 날짜의 리스트 정보를 확인)*/
        urlBuilder.append("&" + URLEncoder.encode("InformCode","UTF-8") + "=" + URLEncoder.encode("PM10", "UTF-8")); /*통보코드검색(PM10, PM25, O3)*/
        System.out.println(urlBuilder.toString());
        URL url = new URL(urlBuilder.toString());
        
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        
        // 위에 @PostMapping 어노테이션에 text가 아닌 application/json로 입력할 경우 아래 set은 생략이 가능
        urlConnection.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + urlConnection.getResponseCode());
        
        BufferedReader br;
        if(urlConnection.getResponseCode() >= 200 && urlConnection.getResponseCode() <= 300) {
            br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        } else {
            br = new BufferedReader(new InputStreamReader(urlConnection.getErrorStream()));
        }
        
        StringBuilder sb = new StringBuilder();
        
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        urlConnection.disconnect();
        System.out.println("sb : "+sb.toString());
        
		return sb.toString();
	}
}
