package matvey.russkov.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Parser {
    private ArrayList url = new ArrayList();//30 url считывает со страницы
    private ArrayList text = new ArrayList();

    public void findUrlWithText() throws IOException {
        for (int i = 0; i <= 2; i++) {
            Document doc = Jsoup.connect("https://www.fmylife.com/tops?page=" + Integer.toString(i)).get();
            Elements pElements = doc.getElementsByAttributeValue("class", "block hidden-xs");

            for (Element pElement : pElements) {
                Element aElement = pElement.child(0);
                url.add(aElement.attr("href"));
            }
            System.out.println(url.size());
        }
    }

    public void readText() throws IOException {
        for (int i = 0; i < url.size(); i++) {
            Document doc = Jsoup.connect("https://www.fmylife.com" + url.get(i)).get();
            Elements pElements = doc.getElementsByAttributeValue("class", "block hidden-xs");
            text.add(pElements.text());
        }
    }
}
