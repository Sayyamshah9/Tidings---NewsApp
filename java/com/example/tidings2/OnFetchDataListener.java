package com.example.tidings2;

import com.example.tidings2.Models.NewsHeadllines;

import java.util.List;

public interface OnFetchDataListener<NewsApiResponse> {

    void onFetchData(List<NewsHeadllines> list, String message);
    void onError(String message);

}
