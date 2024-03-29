package com.example.tidings2.Models;

import java.io.Serializable;
import java.util.List;

public class NewsApiResponse implements Serializable {

    String status;
    int totalResults;
    List<NewsHeadllines> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<NewsHeadllines> getArticles() {
        return articles;
    }

    public void setArticles(List<NewsHeadllines> articles) {
        this.articles = articles;
    }
}
