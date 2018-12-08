package matvey.russkov.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Parser {
    private ArrayList story = new ArrayList();//30 url считывает со страницы, но невсегда.

    public void getStory() throws IOException {
        int countPage = 300;//количество страниц
        for (int i = 0; i < countPage; i++) {
            Document doc = Jsoup.connect("https://www.fmylife.com/tops?page=" + Integer.toString(i)).get();
            Elements blocks = doc.getElementsByAttributeValue("class", "block hidden-xs");
            for (Element block : blocks) {
                Element body = block.child(0);
                Elements text = body.getElementsByAttributeValue("href", body.attr("href"));
                story.add(text.text());
            }
        }
    }
}