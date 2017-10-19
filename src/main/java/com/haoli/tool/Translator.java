package com.haoli.tool;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.haoli.dao.TextDao;
import com.haoli.domain.Text;

@RestController
public class Translator {
	
	//	注意:
	//		1、请先将需要翻译的文本转换为UTF-8编码
	//		2、在发送HTTP请求之前需要对各字段做URL encode。
	//		3、在生成签名拼接 appid+q+salt+密钥 字符串时，q不需要做URL encode，在生成签名之后，
	//		       发送HTTP请求之前才需要对要发送的待翻译文本字段q做URL encode。
	
	@Autowired
	private TextDao textDao;
	private static String baiduTranslateApiUrl = "https://fanyi-api.baidu.com/api/trans/vip/translate";
	private static String appid = "20171018000089230";
	private static String key = "Okzd1FR4mSnzUmv1Cui2";
	private String salt = ""; //随机数

	
	public Translator() {
		this.salt = generateSalt();
	}
	
	public String convertJsonResult(String jsonResult) {
		String[] JsonResultArray = jsonResult.split(",");
		String dst = JsonResultArray[3];
		String[] result = dst.split("\"");
		String finalResult = result[3];
		return finalResult;
	}
	
	@RequestMapping(path="/tool/loadTextById", method=RequestMethod.GET)
	public Text loadTextById(@RequestParam(value="id") Integer id) {
		return textDao.loadTextById(id);
	}
	
	/**
	 * 翻译功能
	 * @param textToBeTranslated 需要翻译的文本
	 * @param from 翻译前语种
	 * @param to	翻译后语种
	 * @return
	 */
	@RequestMapping(path="/tool/translate", method=RequestMethod.POST)
	public String translate(@RequestBody Map params) {
		String textToBeTranslated = (String)params.get("textToBeTranslated");
		String from = (String)params.get("from");
		String to = (String)params.get("to");
		String apiUrl = generateUrl(textToBeTranslated,from ,to);
        StringBuilder result = new StringBuilder(); 
		try {  
            URL url = new URL(apiUrl);    // 把字符串转换为URL请求地址  
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 打开连接  
            connection.connect();// 连接会话  
            // 获取输入流  
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));  
            String line;  
  
            while ((line = br.readLine()) != null) {// 循环读取流  
                result.append(line);  
            }  
            br.close();// 关闭流  
            connection.disconnect();// 断开连接   
            
    		Text text = new Text();
    		text.setContentBeforeTranslated(textToBeTranslated);
    		text.setContentAfterTranslated(unicode2String(convertJsonResult(result.toString())));
    		text.setFrom(from);
    		text.setTo(to);
    		textDao.addTranslateText(text);
    		
        } catch (Exception e) {  
            e.printStackTrace();  
            System.out.println("失败!");  
        }  
		return result.toString();
	}
	
	public String generateUrl(String textToBeTranslated, String from, String to) {
		String url = "";
		String salt = getSalt();
		String sign = generateSign(textToBeTranslated, salt);
		String urlEncodeQ;
		String urlEncodeFrom;
		String urlEncodeTo;
		String urlEncodeAppId;
		String urlEncodeSalt;
		String urlEncodeSign;
		try {
			urlEncodeQ = URLEncoder.encode(new String(textToBeTranslated.getBytes("UTF-8")), "UTF-8");
			urlEncodeFrom = URLEncoder.encode(new String(from.getBytes("UTF-8")), "UTF-8");
			urlEncodeTo = URLEncoder.encode(new String(to.getBytes("UTF-8")), "UTF-8");
			urlEncodeAppId = URLEncoder.encode(new String(appid.getBytes("UTF-8")), "UTF-8");
			urlEncodeSalt = URLEncoder.encode(new String(salt.getBytes("UTF-8")), "UTF-8");
			urlEncodeSign = URLEncoder.encode(new String(sign.getBytes("UTF-8")), "UTF-8");
			url = baiduTranslateApiUrl+"?q="+urlEncodeQ+"&from="+urlEncodeFrom+"&to="+urlEncodeTo+"&appid="+urlEncodeAppId+
					"&salt="+urlEncodeSalt+"&sign="+urlEncodeSign;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  

		return url;
	}
	
	public String generateSign(String textToBeTranslated, String salt){
		String sign = appid+textToBeTranslated+salt+key;
		System.out.println(sign);
		return MD5(textToUtf8(sign));
	}
	
	public String MD5(String text) {
		String md5text = new String();
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(text.getBytes());
			byte b[] = md5.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}

			md5text = buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}  
		return md5text;
	}
	
	public String textToUtf8(String text){
		String utf8text="";
	    try {
			utf8text =  new String(text.getBytes(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  
	    return utf8text;
	}
	
	public String unicode2String(String unicode) {  
		   
	    StringBuffer string = new StringBuffer();  
	   
	    String[] hex = unicode.split("\\\\u");  
	   
	    for (int i = 1; i < hex.length; i++) {  
	   
	        // 转换出每一个代码点  
	        int data = Integer.parseInt(hex[i], 16);  
	   
	        // 追加成string  
	        string.append((char) data);  
	    }  
	   
	    return string.toString();  
	} 
	
	public String generateSalt() {
		return String.valueOf(Math.abs(new Random().nextInt()));
	}
	
	public String getSalt(){
		return this.salt;
	}
	
	public void setSalt(String salt){
		this.salt = salt;
	}
}
