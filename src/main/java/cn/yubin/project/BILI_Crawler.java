package cn.yubin.project;

import cn.yubin.utils.HttpClientUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class BILI_Crawler {

    public static void main(String[] args) {
        for (int i = 1; i <= 155; i++) {   //" + (2 * i - 1) + "
            String firstUrl = "https://bangumi.bilibili.com/media/web_api/search/result?order=3&st=1&sort=0&page=" + i + "&season_type=1&pagesize=20";
            try {
                //1. 发送请求, 获取数据
                String html = HttpClientUtils.doGet(firstUrl);
                //2. 解析数据
                parsePid(html);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void parsePid(String html) {
        Document document = Jsoup.parse(html);
        try {
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("H:\\BILI\\document_buff.txt", true));
//            FileOutputStream out = new FileOutputStream("H:\\BILI\\document_fos.txt",true);
            byte[] bytes = document.toString().getBytes();
            out.write(bytes);

            String newLine = System.getProperty("line.separator");
            out.write(newLine.getBytes());
            out.write("\r\n".getBytes());
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println(document);
        System.out.println("done");
    }
}
