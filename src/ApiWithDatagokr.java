import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class ApiWithDatagokr {
    public static void main(String[] args) throws UnsupportedEncodingException {

        // https://apis.data.go.kr/1741000/TsunamiShelter3/getTsunamiShelter1List
        // ?serviceKey=py3hvzMkgnB6iI%2BOYP%2FSvQcy902tkK5AHJ0ET0H%2BWXnvSPXTkrvltYXY3PZzrZLwI37X3tzcR1RfSx6YTa1U1w%3D%3D
        // &pageNo=1
        // &numOfRows=10
        // &type=xml

        StringBuilder urlBuilder = new StringBuilder(
                "http://apis.data.go.kr/1741000/TsunamiShelter3/getTsunamiShelter1List");
        urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=").append(
                "py3hvzMkgnB6iI%2BOYP%2FSvQcy902tkK5AHJ0ET0H%2BWXnvSPXTkrvltYXY3PZzrZLwI37X3tzcR1RfSx6YTa1U1w%3D%3D");
        urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8"));

        URL url;
        HttpURLConnection conn = null;

        try {
            url = new URL(urlBuilder.toString());
            conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            System.out.println("Response code : " + conn.getResponseCode());

            BufferedReader reader = null;
            if (conn.getResponseCode() >= 200 && conn.getResponseCode() < 300) {
                reader = new BufferedReader((new InputStreamReader(conn.getInputStream())));
            } else {
                reader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }

            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuffer.append(line);
            }

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
