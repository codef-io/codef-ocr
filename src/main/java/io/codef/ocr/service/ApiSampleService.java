package io.codef.ocr.service;

import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import io.codef.ocr.api.*;
import io.codef.ocr.api.EasyCodefServiceType;

/**
 * <pre>
 * io.codef.hecto.service
 *   |_ ApiSampleService.java
 * </pre>
 * 
 * Desc : API 샘플 테스트 서비스
 * @Company : HectoData
 * @Author  : andy@hectodata.co.kr
 * @Date    : Sep 7, 2020 4:32:22 PM
 */
@Service
public class ApiSampleService {

	public String ocrAPI(JSONObject jsonObject) throws InterruptedException, IOException {

		String image = jsonObject.get("base64Data").toString();
		String type = jsonObject.get("ocrType").toString();
		String clientId = jsonObject.get("client_id").toString();
		String clientSecret = jsonObject.get("client_secret").toString();
		String publicKey = jsonObject.get("public_key").toString();

		/**	
		 * #1.쉬운 코드에프 객체 생성
		 */
		EasyCodef codef = new EasyCodef();

		/**	
		 * #2.데모 클라이언트 정보 설정	
		 * - 데모 서비스 가입 후 코드에프 홈페이지에 확인 가능(https://codef.io/#/account/keys)
		 * - 데모 서비스로 상품 조회 요청시 필수 입력 항목
		 */
		codef.setClientInfoForDemo(clientId, clientSecret);
		
		/**	
		 * #3.정식 클라이언트 정보 설정
		 * - 정식 서비스 가입 후 코드에프 홈페이지에 확인 가능(https://codef.io/#/account/keys)
		 * - 정식 서비스로 상품 조회 요청시 필수 입력 항목
		 */
//		codef.setClientInfo(EasyCodefClientInfo.CLIENT_ID, EasyCodefClientInfo.CLIENT_SECRET);
		
		/**	
		 * #4.RSA암호화를 위한 퍼블릭키 설정
		 * - 데모/정식 서비스 가입 후 코드에프 홈페이지에 확인 가능(https://codef.io/#/account/keys)
		 * - 암호화가 필요한 필드에 사용 - encryptValue(String plainText);
		 */
		codef.setPublicKey(publicKey);
		
		/**	
		 * #5.요청 파라미터 설정
		 * - 각 상품별 파라미터를 설정(https://developer.codef.io/products)	
		 */
		
		HashMap<String, Object> parameterMap = new HashMap<String, Object>();
		
		parameterMap.put("Type", "0");
		parameterMap.put("secret_mode", "0");
		parameterMap.put("IdCard_base64", image);
		parameterMap.put("image_return", "0");
		
		/**	
		 * #6.코드에프 정보 조회 요청
		 * - 서비스타입(API:정식, DEMO:데모, SANDBOX:샌드박스)
		 */
		
		String productUrl = "";
		String result = "";
		
		
		switch(type) {
		case "1" : productUrl = "/v1/kr/etc/a/ocr/registration-card"; break;
		case "2" : productUrl = "/v1/kr/etc/a/ocr/drivers-license"; break;
		case "3" : productUrl = "/v1/kr/etc/a/ocr/passport"; break;
		case "4" : productUrl = "/v1/kr/etc/a/ocr/alien-registration-card"; break;
		case "5" : productUrl = "/v1/kr/etc/a/ocr/back-side"; break;
		default : productUrl = "/v1/kr/etc/a/ocr/registration-card";
		}
		
		result = codef.requestProduct(productUrl, EasyCodefServiceType.DEMO, parameterMap);
		
		/**	#7.코드에프 정보 결과 확인	*/
		System.out.println(result);
		
		return result;
	}
	
}
