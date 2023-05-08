package server.server.utils;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class UriCreator {
    public static URI createUri(String defaultUrl, long resourceId) {
        return UriComponentsBuilder
                .newInstance()
                .path(defaultUrl + "/{resource-id}")
                .buildAndExpand(resourceId)
                .toUri();
    }

    public static URI createUri(String defaultUrl, long answerId, long answerVoteId){
        return UriComponentsBuilder
                .newInstance()
                .path(defaultUrl + "/{answer-id}/answer-vote/{answer-vote-id}")
                .buildAndExpand(answerId, answerVoteId)
                .toUri();
    }
}
