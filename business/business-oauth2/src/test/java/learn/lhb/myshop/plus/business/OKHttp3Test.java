package learn.lhb.myshop.plus.business;

import com.google.common.collect.Maps;
import learn.lhb.myshop.plus.commons.utils.MapperUtil;
import learn.lhb.myshop.plus.commons.utils.OkHttpClientUtil;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Map;

/**
 * 测试 OKHttp3 框架
 * @author 梁鸿斌
 * @date 2020/3/7.
 * @time 17:48
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OKHttp3Test {

    /**
     * 用OKHttp模拟Get请求
     */
    @Test
    public void getTest() {
        String url = "https://www.baidu.com";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 用OKHttp模拟post请求
     */
    @Test
    public void postTest() {
        String url = "http://localhost:9001/oauth/token";
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("username","admin")
                .add("password", "123456")
                .add("grant_type", "password")
                .add("client_id", "client")
                .add("client_secret", "secret")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void postUtilsTest() {
        String url = "http://localhost:9001/oauth/token";
        Map<String, String> params = Maps.newHashMap();
        params.put("username", "admin");
        params.put("password", "123456");
        params.put("grant_type", "password");
        params.put("client_id", "client");
        params.put("client_secret", "secret");
        try {
            Response response = OkHttpClientUtil.getInstance().postData(url, params);
            String jsonString = response.body().string();
            Map<String,Object> jsonMap = MapperUtil.json2map(jsonString);
            String token = String.valueOf(jsonMap.get("access_token"));
            System.out.println(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
