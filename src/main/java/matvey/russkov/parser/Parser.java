package matvey.russkov.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Parser {
    private ArrayList arrayOfStories = new ArrayList();//30 url считывает со страницы, но невсегда.

    public void getStories() throws IOException {
        final int countPage = 300;//количество страниц
        for (int i = 0; i < countPage; i++) {
            Document doc = Jsoup.connect("https://www.fmylife.com/tops?page=" + Integer.toString(i)).get();
            Elements blocks = doc.getElementsByAttributeValue("class", "block hidden-xs");
            for (Element block : blocks) {
                Element body = block.child(0);
                Elements story = body.getElementsByAttributeValue("href", body.attr("href"));
                arrayOfStories.add(story.text());
            }
        }
    }
}