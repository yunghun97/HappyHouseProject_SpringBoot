package com.ssafy.happyhouse.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.BaseaddressDto;
import com.ssafy.happyhouse.model.BookmarkDto;
import com.ssafy.happyhouse.model.HouseInfoAllDto;
import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.HouseParamDto;
import com.ssafy.happyhouse.model.service.MapServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/map")
public class MapController {
	
	@Autowired
	private MapServiceImpl mapService;
	
	@GetMapping("/bookmark")
	private ResponseEntity<List<HouseInfoAllDto>> bookmark() throws Exception{
		return new ResponseEntity<List<HouseInfoAllDto>>(mapService.getSido(), HttpStatus.OK);
	}
	@PostMapping("/bookmark")
	private void regitBookmark(BookmarkDto bookmarkDto) throws Exception{
		mapService.regitBookMark(bookmarkDto);
		return; 
	}
	
	@GetMapping("/sido")
	private ResponseEntity<List<HouseInfoAllDto>> sido() throws Exception{
		return new ResponseEntity<List<HouseInfoAllDto>>(mapService.getSido(), HttpStatus.OK);
	}
	@GetMapping("/gugun")
	private ResponseEntity<List<HouseInfoAllDto>> gugun(@RequestParam("sido") String sido) throws Exception{
		return new ResponseEntity<List<HouseInfoAllDto>>(mapService.getGugun(sido), HttpStatus.OK);
	}

	@PostMapping("/dong")
	private String dong(@RequestBody HashMap<String, String> map) throws Exception{
		
		StringBuilder sb = new StringBuilder();
		try {
			String apiUrl = map.get("URL");
			String SERVICE_KEY = map.get("serviceKey");
			String LAWD_CD = map.get("LAWD_CD");
			String DEAL_YMD = map.get("DEAL_YMD");
			String count = map.get("numOfRows");
			StringBuilder urlBuilder = new StringBuilder("http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev");
			System.out.println(SERVICE_KEY);
			urlBuilder.append("?serviceKey="+ URLEncoder.encode(SERVICE_KEY, "UTF-8")); /*Service Key*/
			urlBuilder.append("&LAWD_CD="+LAWD_CD); /*지역코드*/
			urlBuilder.append("&DEAL_YMD="+DEAL_YMD); /*계약월*/
			urlBuilder.append("&numOfRows="+count);
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			System.out.println("Response code: " + conn.getResponseCode());
			BufferedReader rd;
			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	@PostMapping("/apt")
	public String getAptImg(@RequestParam("aptName") String aptName) {
		StringBuilder sb = new StringBuilder();
		try {
			StringBuilder urlBuilder = new StringBuilder("https://www.google.com/search?q="+aptName+"&tbm=isch&tbs=qdr:y");
//			StringBuilder urlBuilder = new StringBuilder("https://www.google.com/search?q="+aptName);
//			StringBuilder urlBuilder = new StringBuilder("https://www.google.com/");
//			System.out.println(urlBuilder.toString());
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			BufferedReader rd;
			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	@PostMapping("/covid")
	public String getCovidCenter(@RequestBody HashMap<String, String> map) {
		StringBuilder sb = new StringBuilder();
		String serviceKey = map.get("serviceKey");
		try {
			StringBuilder urlBuilder = new StringBuilder("https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=10000&serviceKey="+serviceKey);
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			BufferedReader rd;
			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
//	@GetMapping("/apt")
//	private ResponseEntity<List<HouseInfoAllDto>> apt(@RequestParam("dong") String dong) throws Exception{
//		return new ResponseEntity<List<HouseInfoAllDto>>(mapService.getApt(dong), HttpStatus.OK);
//	}
	
}
