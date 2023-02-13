import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class ApiExplorersWithDatagokr {
    public static void main(String[] args) throws UnsupportedEncodingException {
        /*
         * 외교부 국가/지역별 최신 안전소식(코로나 관련) - 중국
         * https://apis.data.go.kr/1262000/CountryCovid19SafetyServiceNew/
         * getCountrySafetyNewsListNew
         * ?serviceKey=
         * &returnType=JSON
         * &numOfRows=10
         * &pageNo=1
         * &cond[country_nm::EQ]=중국
         */

        StringBuilder urlBuilder = new StringBuilder(
                "http://apis.data.go.kr/1262000/CountryCovid19SafetyServiceNew/getCountrySafetyNewsListNew"); /* URL */
        // 2. 오픈 API의요청 규격에 맞는 파라미터 생성, 발급받은 인증키.
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=").append(
                "py3hvzMkgnB6iI%2BOYP%2FSvQcy902tkK5AHJ0ET0H%2BWXnvSPXTkrvltYXY3PZzrZLwI37X3tzcR1RfSx6YTa1U1w%3D%3D"); /*
                                                                                                                        * Service
                                                                                                                        * Key
                                                                                                                        */
        urlBuilder.append("&" + URLEncoder.encode("returnType", "UTF-8") + "="
                + URLEncoder.encode("JSON", "UTF-8")); /* XML 또는 JSON */
        urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*
                                                                                                                    * 한
                                                                                                                    * 페이지
                                                                                                                    * 결과
                                                                                                                    * 수
                                                                                                                    */
        urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*
                                                                                                                * 페이지 번호
                                                                                                                */
        urlBuilder.append("&" + URLEncoder.encode("cond[country_nm::EQ]", "UTF-8") + "="
                + URLEncoder.encode("중국", "UTF-8")); /* ISO 2자리코드 */

        URL url;
        HttpURLConnection conn = null;
        try {
            url = new URL(urlBuilder.toString());
            // 정보 보내기 요청이 날아감
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            // conn.setRequestProperty(null, null);
            System.out.println("Response code : " + conn.getResponseCode());
            // 방어코드
            BufferedReader reader = null;
            if (conn.getResponseCode() >= 200 && conn.getResponseCode() < 300) {
                // 정상
                // 값 뽑아내기
                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                // 비정상
                reader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            StringBuffer stringBuffer = new StringBuffer();
            // reader.readLine() 두번 넣으면 두번째 라인 부터 읽어서 엉망됨
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuffer.append(line);

            }
            int i = 1;
            reader.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
    }
}