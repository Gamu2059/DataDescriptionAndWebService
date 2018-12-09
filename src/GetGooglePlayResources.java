import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.net.URL;

public class GetGooglePlayResources {

    public static void main(String[] args) {
        try {
            String[] titles = getGameTitleFromGooglePlay();
            if (titles == null) {
                System.out.println("エラーが発生したか、もしくは該当するゲームがありませんでした。");
                return;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String[] getGameTitleFromGooglePlay() {
        try {
            URL url = new URL("https://play.google.com/store/apps/collection/cluster?clp=SiwKKgokcHJvbW90aW9uXzMwMDA3OTFfbmV3X3JlbGVhc2VzX2dhbWVzEAcYAw%3D%3D:S:ANO1ljJAzZo&gsr=Ci5KLAoqCiRwcm9tb3Rpb25fMzAwMDc5MV9uZXdfcmVsZWFzZXNfZ2FtZXMQBxgD:S:ANO1ljIA02c");
            Document doc = Jsoup.parse(url, 10000);
            Elements titleElem = doc.select("[class=title]").select("[aria-hidden=true]");

            if (titleElem.isEmpty()) return null;
            String[] titles = new String[titleElem.size()];
            for (int i=0;i<titles.length;i++) {
                titles[i] = titleElem.get(i).attr("title");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
