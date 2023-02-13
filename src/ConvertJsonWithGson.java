import java.util.Map;

import com.google.gson.Gson;

import beans.MemberBean;

public class ConvertJsonWithGson {
    public static void main(String[] args) {
        // 문자열을 json으로 바꾸기
        Gson gson = new Gson();
        String jsonStr = "{id:1, name:yojulab}";
        Map jsonMap = gson.fromJson(jsonStr, Map.class);

        // Map -> 문자열 json
        String mapStr = gson.toJson(jsonMap);

        // 문자열 json -> object(bean, model, vo)
        String jsonStrBean = "{firstName : yo, secondName:ju, handleName:lab}";
        MemberBean memberBean = gson.fromJson(jsonStrBean, MemberBean.class);

        int i = 0;
    }

}
