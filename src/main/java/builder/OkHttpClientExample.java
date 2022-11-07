package builder;

import okhttp3.ConnectionSpec;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 建造者模式
 * <p>
 * okhttpclient示例
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/11/7
 * @since
 */
public class OkHttpClientExample {
    // final OkHttpClient client = new OkHttpClient();
    public static OkHttpClient create(long connectTimeOut) {
        return new OkHttpClient().newBuilder().connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT)).connectTimeout(connectTimeOut, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).retryOnConnectionFailure(true).followRedirects(true).followSslRedirects(true).hostnameVerifier((s, sslSession) -> true).cookieJar(new CookieJar() {
            private List<Cookie> cookies;

            @Override
            public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                this.cookies = cookies;
            }

            @Override
            public List<Cookie> loadForRequest(HttpUrl url) {
                if (cookies != null) {
                    return cookies;
                }
                return Collections.emptyList();
            }
        }).build();
    }

    final OkHttpClient client = create(100000);

    String run(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static void main(String[] args) throws IOException {
        OkHttpClientExample example = new OkHttpClientExample();
        String response = example.run("http://t.weather.sojson.com/api/weather/city/101030100");
        System.out.println(response);
    }
}
