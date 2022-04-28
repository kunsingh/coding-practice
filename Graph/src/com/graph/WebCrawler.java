package com.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {
    private Queue<String> queue;
    private List<String> discoveredWebSiteList;

    public WebCrawler(){
        this.queue = new LinkedList<>();
        this.discoveredWebSiteList = new ArrayList<>();
    }

    public void discoverWeb(final String root){
        this.queue.add(root);
        this.discoveredWebSiteList.add(root);

        while (!queue.isEmpty()){
            String s = queue.remove();
            String rawHtml = readURL(s);
            String regexp = "http://(\\w+\\.)*(\\w+)";
            Pattern pattern = Pattern.compile(regexp);
            Matcher matcher = pattern.matcher(rawHtml);

            while (matcher.find()){
                String actualUrl = matcher.group();
                if(!discoveredWebSiteList.contains(actualUrl)){
                    discoveredWebSiteList.add(actualUrl);
                    System.out.println("URL found: "+actualUrl);
                    queue.add(actualUrl);
                }
            }
        }
    }

    private String readURL(String s) {
        StringBuilder rawHtml = new StringBuilder();
        try {
            URL url = new URL(s);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine = "";

            while((inputLine = in.readLine())!=null){
                rawHtml.append(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rawHtml.toString();
    }

    public static void main(String[] args) {
        WebCrawler webCrawler = new WebCrawler();
        webCrawler.discoverWeb("http://www.basicsbehind.com");
    }
}
