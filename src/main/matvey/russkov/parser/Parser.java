package main.matvey.russkov.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;

class Parser {
    private final int countPage;
    private AbstractList<String> stories = new ArrayList<>();//30 url считывает со страницы, но невсегда.

    Parser(int countPage) {
        this.countPage = countPage;
    }

    void getStories() throws IOException {
        for (int i = 0; i < countPage; i++) {
            try {
                /*
                 * иногда происходит дисконект в 22 строке
                 * скорее всего связано с подключением к интернету
                 * на всякий случай добавил задержку
                 */
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
            Document doc = Jsoup.connect("https://www.fmylife.com/tops?page=" + i).get();
            Elements blocks = doc.getElementsByAttributeValue("class", "block hidden-xs");
            for (Element block : blocks) {
                Element body = block.child(0);
                Elements story = body.getElementsByAttributeValue("href", body.attr("href"));
                stories.add(story.text());// может добавить не все истории
            }
        }
    }
}