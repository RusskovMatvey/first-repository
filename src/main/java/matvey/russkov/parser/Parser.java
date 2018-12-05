package matvey.russkov.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Vector;

public class Parser {
    private static Vector url = new Vector();//22 url считывает со страницы
    private static Vector text = new Vector();

    public static void findUrlWithText() throws IOException {
        Document doc = Jsoup.connect("https://www.fmylife.com").get();
        Elements pElements = doc.getElementsByAttributeValue("class", "block hidden-xs");

        int i = 0;
        for (Element pElement : pElements) {
            Element aElement = pElement.child(0);
            url.add(aElement.attr("href"));
            i++;
        }
    }

    public static void readText() throws IOException {
        for(int i = 0; i < url.size(); i++) {
            Document doc = Jsoup.connect("https://www.fmylife.com" + url.get(i)).get();
            Elements pElements = doc.getElementsByAttributeValue("class", "block hidden-xs");
            text.add(pElements.text());
            System.out.println(text.get(i));
        }
    }
}
