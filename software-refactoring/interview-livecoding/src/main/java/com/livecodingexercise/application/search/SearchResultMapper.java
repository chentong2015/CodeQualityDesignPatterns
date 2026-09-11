package com.livecodingexercise.application.search;

import com.livecodingexercise.application.search.SearchResponse.TripResponse;
import com.livecodingexercise.domain.SearchResult;
import com.livecodingexercise.domain.SearchResults;

import java.util.ArrayList;
import java.util.List;

final class SearchResultMapper {

    static SearchResponse map(SearchResults results) {
        List<TripResponse> list = new ArrayList<>();
        for (int i = 0; i < results.getCount(); i++) {
            SearchResult searchResult = results.getResults().get(i);
            TripResponse map = map(searchResult);
            list.add(map);
        }
        return new SearchResponse(list);
    }

    static TripResponse map(SearchResult result) {
        return new TripResponse(
                result.getId().toString(),
                result.getDeparture(),
                result.getArrival(),
                result.getFormattedPrice(),
                result.getDriverName()
        );
    }
}
