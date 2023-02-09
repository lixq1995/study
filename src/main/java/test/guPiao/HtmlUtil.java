package test.guPiao;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.gargoylesoftware.htmlunit.BrowserVersion;
//import com.gargoylesoftware.htmlunit.HttpMethod;
//import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
//import com.gargoylesoftware.htmlunit.Page;
//import com.gargoylesoftware.htmlunit.WebClient;
//import com.gargoylesoftware.htmlunit.WebRequest;
//import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
//import com.gargoylesoftware.htmlunit.html.HtmlButton;
//import com.gargoylesoftware.htmlunit.html.HtmlPage;
//import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
//import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

public class HtmlUtil {
    WebClient webClient;
    //初始化
    public HtmlUtil(){
        webClient = new WebClient(BrowserVersion.CHROME);//新建一个模拟谷歌Chrome浏览器的浏览器客户端对象
        webClient.getOptions().setThrowExceptionOnScriptError(false);//当JS执行出错的时候是否抛出异常, 这里选择不需要
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);//当HTTP的状态非200时是否抛出异常, 这里选择不需要
        webClient.getOptions().setActiveXNative(false);
        webClient.getOptions().setCssEnabled(false);//是否启用CSS, 因为不需要展现页面, 所以不需要启用
        webClient.getOptions().setJavaScriptEnabled(true); //很重要，启用JS。有些网站要开启！
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());//很重要，设置支持AJAX
        webClient.getOptions().setTimeout(30000);
    }
    //获取某个url的web客户端
    public String htmlUnitUrl(String url, WebClient webClient) {
        try {
            WebRequest request = new WebRequest(new URL(url), HttpMethod.GET);
            Map<String, String> additionalHeaders = new HashMap<String, String>();
            additionalHeaders
                    .put("User-Agent",
                            "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.104 Safari/537.36");
            additionalHeaders.put("Accept-Language", "zh-CN,zh;q=0.8");
            additionalHeaders.put("Accept", "*/*");
            request.setAdditionalHeaders(additionalHeaders);
            // 获取某网站页面
            Page page = webClient.getPage(request);
            return page.getWebResponse().getContentAsString();
        } catch (Exception e) {

        }
        return null;
    }
    //爬取某网页
    public void work(String url) {
        try {
            HtmlPage page = webClient.getPage(url);//打开网页
            int pageCount = 177;
            for(int i=1;i<=pageCount;i++) {
                //当访问速度过快时，后台浏览器会禁止，在这里可加入适当延迟的代码
                /**
                 *延迟执行的代码
                 */

                String content = htmlUnitUrl("http://q.10jqka.com.cn/index/index/board/all/field/zdf/order/desc/page/"+i+"/ajax/1/",webClient);
                if(content.contains("Nginx forbidden."))
                    return;
                else {
                    writeFile("F://测试//"+i+".html",content);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        HtmlUtil demo=new HtmlUtil();
        String url = "http://q.10jqka.com.cn/";
        demo.work(url);
    }
    /**
     * 保存抓取的html到本地
     * @param path
     * @param content
     */
    public static boolean writeFile(String path,String content) {

        File file = new File(path);
        boolean isSuccess = true;
        System.out.println(path);
        // if file doesnt exists, then create it
        if (!file.exists()) {
            try {
                isSuccess = file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                isSuccess = false;
            }
        }else {
            file.delete();
        }
        FileWriter fw;
        try {
            fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
            System.out.println("写入成功.");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("写入失败.");
            isSuccess = false;
        }
        return isSuccess;
    }
}