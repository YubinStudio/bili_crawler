package cn.yubin.project;

import cn.yubin.utils.HttpClientUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BILI_User {
    public static void main(String[] args) {
        //  http://space.bilibili.com/28328405
        String mid = RandomStringUtils.randomNumeric(8);
        String userUrl = "http://space.bilibili.com/ajax/member/GetInfo?mid=" + 28328405;

        try {
            String html = HttpClientUtils.doGet(userUrl);
            userMassage(html);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void userMassage(String html) {
        Document document = Jsoup.parse(html);
        try {
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("H:\\BILI\\user.txt"));
            byte[] bytes = document.toString().getBytes();
            out.write(bytes);

            String newLine = System.getProperty("line.separator");
            out.write(newLine.getBytes());
            out.write("\r\n".getBytes());
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(document.title());
    }
}
