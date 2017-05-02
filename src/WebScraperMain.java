//Simple web scraper looking at bike searches
//Shows link to bike page and price
//TODO make a GUI for it, and allow for filtering
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScraperMain {

	public static void main(String[] args) {
		
		try{
			
			Document doc = Jsoup.connect("https://stlouis.craigslist.org/search/bik").get();
	
			Elements links = doc.select("a[href]");
		
			for (Element link: links){
				if (link.hasClass("result-image gallery")){
					System.out.println("https://stlouis.craigslist.org" + link.getElementsByClass("result-image gallery").attr("href"));
					System.out.println(link.getElementsByClass("result-price").html());
				}
			}
		
		}catch (IOException e){
			e.printStackTrace();
		}
		
	}

}
