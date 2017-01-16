package Controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Model.MNews;
import Model.News;

/**
 *
 * @author lv
 */
public class GetNews {
	LinkedList<News> ready;
	MNews mNews;
	public GetNews(){
		mNews=new MNews();
	}
    /**
     * ��ȡ��ҳȫ������
     */
    public String getHtmlContent(String htmlurl) {
        URL url;
        String temp;
        StringBuffer sb = new StringBuffer();
        try {
            url = new URL(htmlurl);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));// ��ȡ��ҳȫ������
            while ((temp = in.readLine()) != null) {
                sb.append(temp);
            }
            in.close();
        } catch (final MalformedURLException me) {
            System.out.println("�������URL��ʽ������!");
            me.getMessage();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public LinkedList<News> GetNew(String s){
    	//String pattern="<a\\s+href\\s*=\\s*(\"[^\"]*\"|[^\\s>]*)\\s+class\\s=*>";
    	ready=new LinkedList<News>();
    	String pattern="<a\\s+href=\'(.*?)\'\\sclass='bt_link'\\stitle=\'(.*?)\'";
    	Pattern pattern2=Pattern.compile(pattern,Pattern.CASE_INSENSITIVE);
    	Matcher matcher=pattern2.matcher(s);
    	while(matcher.find()){
    		int start=matcher.start();
    		int end=matcher.end();
    		String match=s.substring(start,end);
    		String[] reStrings=match.split("'");
    		//������ô�����Ӻͱ���ȡ����
    		for(int ii=0;ii<reStrings.length;ii++){
    			System.out.print(reStrings[ii]+"   ");
    		}
    		System.out.println();
    		reStrings[1]="http://www.hebau.edu.cn"+reStrings[1];
    		ready.add(new News(reStrings[5], reStrings[1]));
    		//System.out.println(match);
    	}
    	//���и������ݿ���������
    	for(int ii=0;ii<ready.size()-1;ii++)
    		mNews.UpdateNews(ready.get(ii+1), ii+1);
    	return ready;
    }

    
   
}