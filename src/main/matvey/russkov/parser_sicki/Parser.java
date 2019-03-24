package main.matvey.russkov.parser_sicki;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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

    ArrayList<String> getStories() throws IOException {
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
            Document doc = Jsoup.connect("http://sickipedia.net/hottest/today?pageIndex=" + "0").get();
            Elements blocks = doc.getElementsByTag("script");
            String json = blocks.get(3).toString();
            //System.out.println(json.substring(json.indexOf("["), json.indexOf("]") + 1));
            //ObjectMapper objectMapper = new ObjectMapper();
            stories.add(json.substring(json.indexOf("["), json.indexOf("]") + 1));
        }
        return (ArrayList<String>) stories;
    }
}