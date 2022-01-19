
//Jeongsoo Kim

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
// 5/23/17
public class Words 
{
    private String word;
    private String definition;
    private String category;
    private int vocabNum;
    private ArrayList<String> list1 = new ArrayList<String>();
    private ArrayList<String> list2 = new ArrayList<String>();
    private ArrayList<String> list3 = new ArrayList<String>();
    private Document doc;
    
    public Words()
    {
        int i = getRanNum();
        connect();
        vocabNum = i + 1;
        word = list1.get(i);
        definition = list2.get(i);
        category = list3.get(i);
    }
    
    public Words(String w, String d, String c)
    {
        word = w;
        definition = d;
        category = c;
    }
    
    public String toString()
    {
        return  "-----------------------------" + "\n" + "Word: " + word + "\n" + "Definition: " + definition + "\n" + "Category: " + category + "\n"  ;
    }
    
    public String getWord()
    {
        return word;
    }
    
    public String getDef()
    {
        return definition;
    }
    
    public String getCat()
    {
        return category;
    }
    
    public String getNum()
    {
        return "" + vocabNum;
    }
    
    public int getRanNum()
    {
        return (int)(Math.random()*500);
    }
    
    public void connect()
    {
        try
        {
            String site = "http://www.satvocabulary.us/";
            doc = Jsoup.connect(site).get();
            
            Element e = doc.body();
            Elements e1 = e.getElementsByTag("tbody");
            for(int i = 1; i < 501; i++)
            {
                list1.add(e1.select("tbody").get(1).getElementsByTag("tr").get(i).getElementsByTag("td").get(1).text());
                list2.add(e1.select("tbody").get(1).getElementsByTag("tr").get(i).getElementsByTag("td").get(2).text());
                list3.add(e1.select("tbody").get(1).getElementsByTag("tr").get(i).getElementsByTag("td").get(3).text());
                //ordsList.add(new Words(list1.get(i),list2.get(i) ,list3.get(i)));
            }
            
            
        }
        
        catch(IOException e)
        {
            System.out.println("IOException found");
        }
    }
}
