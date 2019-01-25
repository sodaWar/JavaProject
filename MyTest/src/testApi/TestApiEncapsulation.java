package testApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;


public class TestApiEncapsulation {

    private String charset = "utf-8";
    private Integer connectTimeout = null;
    private Integer socketTimeout = null;
    private String proxyHost = null;
    private Integer proxyPort = null;

    /**
     * Do GET request
     * @param url
     * @return
     * @throws Exception
     * @throws IOException
     */
    public String doGet(String url) throws Exception {

        URL localURL = new URL(url);

        URLConnection connection = openConnection(localURL);
        HttpURLConnection httpURLConnection = (HttpURLConnection)connection;

        httpURLConnection.setRequestProperty("Accept-Charset", charset);
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuffer resultBuffer = new StringBuffer();
        String tempLine = null;

        if (httpURLConnection.getResponseCode() >= 300) {
            throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
        }

        try {
            inputStream = httpURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(inputStreamReader);

            while ((tempLine = reader.readLine()) != null) {
                resultBuffer.append(tempLine);
            }

        } finally {

            if (reader != null) {
                reader.close();
            }

            if (inputStreamReader != null) {
                inputStreamReader.close();
            }

            if (inputStream != null) {
                inputStream.close();
            }

        }

        return resultBuffer.toString();
    }

    /**
     * Do POST request
     * @param url
     * @param parameterMap
     * @return
     * @throws Exception
     */
    public String doPost(String url, Map parameterMap) throws Exception {

        /* Translate parameter map to parameter date string */
        StringBuffer parameterBuffer = new StringBuffer();
        if (parameterMap != null) {
            // keySet()方法获取所有的Map对象的key值,迭代器是一个对象,它可以遍历并选择序列中的对象,使用方法iterator()要求容器返回一个Iterator,返回一个序列值,该序列包含所有的key值
            Iterator iterator = parameterMap.keySet().iterator();
            String key = null;
            String value = null;
            // hasNext()检查序列中是否还有元素,next()获得序列中的下一个元素
            while (iterator.hasNext()) {
                key = (String)iterator.next();
                if (parameterMap.get(key) != null) {
                    value = (String)parameterMap.get(key);
                } else {
                    value = "";
                }
                // 将map对象的key和value值添加到一个parameterBuffer对象中,目的是将map数据转换为string类型的数据
                parameterBuffer.append(key).append("=").append(value);
                if (iterator.hasNext()) {
                    parameterBuffer.append("&");
                }
            }
        }
        // 这里parameterBuffer是post接口请求的参数
        System.out.println("POST parameter : " + parameterBuffer.toString());

        URL localURL = new URL(url);

        URLConnection connection = openConnection(localURL);
        HttpURLConnection httpURLConnection = (HttpURLConnection)connection;

        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Accept-Charset", charset);
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(parameterBuffer.length()));

        OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuffer resultBuffer = new StringBuffer();
        String tempLine = null;

        try {
            outputStream = httpURLConnection.getOutputStream();
            outputStreamWriter = new OutputStreamWriter(outputStream);

            outputStreamWriter.write(parameterBuffer.toString());
            outputStreamWriter.flush();

            if (httpURLConnection.getResponseCode() >= 300) {
                throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
            }

            inputStream = httpURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(inputStreamReader);
            // reader对象中有read()方法和readLine()方法,第一种是读取一个字符,第二种是读取一行字符串
            while ((tempLine = reader.readLine()) != null) {
                resultBuffer.append(tempLine);
            }

        } finally {

            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }

            if (outputStream != null) {
                outputStream.close();
            }

            if (reader != null) {
                reader.close();
            }

            if (inputStreamReader != null) {
                inputStreamReader.close();
            }

            if (inputStream != null) {
                inputStream.close();
            }

        }

        return resultBuffer.toString();
    }
    /* 这里是Java.net.URL对象使用Proxy访问Internet资源,java.net包下提供了Proxy和ProxySelector两个类,Proxy代表一个代理服务器,ProxySelector代表一个代理选择器
    代理服务器是介于浏览器和Web服务器之间的一台服务器,有了它之后,浏览器不是直接到Web服务器去取得网页数据而是向代理服务器发出请求,且大部分代理服务器都具有缓冲的功能,它不断将新取得的数据储存到它本机的存储器上
    如果浏览器所请求的数据在它本机的存储器上已经存在而且是最新的，那么它就不重新从Web服务器取数据，而直接将存储器上的数据传送给用户的浏览器，这样就能显著提高浏览速度和效率
    所以代理服务器作用是突破自身IP限制,并且对外隐藏自身IP地址,提高访问速度
    这里Proxy类的使用是为了java URL对象通过代理访问网络资源,以适用代理上网的方式
    */
    private URLConnection openConnection(URL localURL) throws IOException {
        URLConnection connection;                                                                                       // 创建一个URLConnection对象
        if (proxyHost != null && proxyPort != null) {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));                      // 构造Proxy对象,以适用代理上网的方式
            connection = localURL.openConnection(proxy);                                                                // 使用指定的代理服务器打开连接
        } else {
            connection = localURL.openConnection();                                                                     // 通过统一资源定位器(java.net.URL)获取连接器(java.net.URLConnection),然后openConnection()会返回URLConnection类型
        }
        return connection;
    }

    /**
     * Render request according setting
     * @param
     */
    private void renderRequest(URLConnection connection) {

        if (connectTimeout != null) {
            connection.setConnectTimeout(connectTimeout);
        }

        if (socketTimeout != null) {
            connection.setReadTimeout(socketTimeout);
        }

    }

    /*
     * Getter & Setter
     */
    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public Integer getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(Integer socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    public Integer getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(Integer proxyPort) {
        this.proxyPort = proxyPort;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

}