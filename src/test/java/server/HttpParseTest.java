package server;

import com.base.HttpParseUtils;
import com.web.HttpRequest;

public class HttpParseTest {

    public static void main(String[] args) {
        String httpRequest = "GET / HTTP/1.1\n" +
                "Host: 127.0.0.1:8100\n" +
                "Connection: keep-alive\n" +
                "Cache-Control: max-age=0\n" +
                "sec-ch-ua: \"Google Chrome\";v=\"89\", \"Chromium\";v=\"89\", \";Not A Brand\";v=\"99\"\n" +
                "sec-ch-ua-mobile: ?0\n" +
                "Upgrade-Insecure-Requests: 1\n" +
                "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.90 Safari/537.36\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9\n" +
                "Sec-Fetch-Site: none\n" +
                "Sec-Fetch-Mode: navigate\n" +
                "Sec-Fetch-User: ?1\n" +
                "Sec-Fetch-Dest: document\n" +
                "Accept-Encoding: gzip, deflate, br\n" +
                "Accept-Language: zh-CN,zh;q=0.9\n" +
                "\n";

        HttpRequest request = HttpParseUtils.processHttpRequest(httpRequest);

    }
}
