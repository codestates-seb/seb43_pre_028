//package server.server.question;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//public class StubDate {
//    // question contoller에 추가하면 됩니다.
//    // 코드가 길어져서 걍 따로 뺐어요.
//    Map<String, ArrayList> result = new HashMap<>();
//    Map<String, String> data = new HashMap<>();
//    ArrayList arr = new ArrayList();
//
//
//        data.put("questionid", "1");
//        data.put("title", "우리는 테스트를 해봅시다.");
//        data.put("problem", "테스트가 될것인가? 테스트가 안되면 너도 죽고 나도 죽자. 도데체 이게 사람하나 잡느라고 뒤지겠네. 내가 너무 지식이 부족해서 팀원들한테 민폐만 끼치고 눈물 주루룩");
//        data.put("tried", "무한 반복 테스트");
//        data.put("votes", "10");
//        data.put("views", "8");
//        data.put("answers", "0");
//        data.put("createdAt", null);
//        data.put("modifiedAt", "2023-04-23");
//        data.put("userName", "티끌모아파산");
//        data.put("userImage", "https://picsum.photos/seed/picsum/200/300");
//        data.put("askedCount", "15");
//        arr.add(data);
//        result.put("data", arr);
//
//        data.put("questionid", "2");
//        data.put("title", "나는 누구인가?");
//        data.put("problem", "서버와 통신 가능한지");
//        data.put("tried", "되어야 한다.....");
//        data.put("votes", "3");
//        data.put("views", "5");
//        data.put("answers", "2");
//        data.put("createdAt", "2023-01-01");
//        data.put("modifiedAt", "2023-01-03");
//        data.put("userName", "기정님은톰");
//        data.put("userImage", "https://picsum.photos/200/300/?blur");
//        data.put("askedCount", "15");
//        arr.add(data);
//        result.put("data", arr);
//
//        data.put("questionid", "3");
//        data.put("title", "test1");
//        data.put("problem", "서버와 통신 가능한지");
//        data.put("tried", "되어야 한다.....");
//        data.put("votes", "10");
//        data.put("views", "8");
//        data.put("answers", "0");
//        data.put("createdAt", null);
//        data.put("modifiedAt", "2023-04-23");
//        data.put("userName", "수진님");
//        data.put("userImage", "https://picsum.photos/id/870/200/300?grayscale&blur=2");
//        data.put("askedCount", "15");
//        arr.add(data);
//        result.put("data", arr);
//
//        data.put("questionid", "4");
//        data.put("title", "test1");
//        data.put("problem", "서버와 통신 가능한지");
//        data.put("tried", "되어야 한다.....");
//        data.put("votes", "10");
//        data.put("views", "8");
//        data.put("answers", "0");
//        data.put("createdAt", null);
//        data.put("modifiedAt", "2023-04-23");
//        data.put("userName", "수진님");
//        data.put("userImage", "https://picsum.photos/seed/picsum/200/300");
//        data.put("askedCount", "15");
//        arr.add(data);
//        result.put("data", arr);
//
//        data.put("questionid", "5");
//        data.put("title", "test1");
//        data.put("problem", "서버와 통신 가능한지");
//        data.put("tried", "되어야 한다.....");
//        data.put("votes", "10");
//        data.put("views", "8");
//        data.put("answers", "0");
//        data.put("createdAt", null);
//        data.put("modifiedAt", "2023-04-23");
//        data.put("userName", "수진님");
//        data.put("userImage", "https://picsum.photos/seed/picsum/200/300");
//        data.put("askedCount", "15");
//        arr.add(data);
//        result.put("data", arr);
//
//        data.put("questionid", "6");
//        data.put("title", "test1");
//        data.put("problem", "서버와 통신 가능한지");
//        data.put("tried", "되어야 한다.....");
//        data.put("votes", "10");
//        data.put("views", "8");
//        data.put("answers", "0");
//        data.put("createdAt", null);
//        data.put("modifiedAt", "2023-04-23");
//        data.put("userName", "수진님");
//        data.put("userImage", "https://picsum.photos/seed/picsum/200/300");
//        data.put("askedCount", "15");
//        arr.add(data);
//        result.put("data", arr);
//
//        data.put("questionid", "7");
//        data.put("title", "test1");
//        data.put("problem", "서버와 통신 가능한지");
//        data.put("tried", "되어야 한다.....");
//        data.put("votes", "10");
//        data.put("views", "8");
//        data.put("answers", "0");
//        data.put("createdAt", null);
//        data.put("modifiedAt", "2023-04-23");
//        data.put("userName", "수진님");
//        data.put("userImage", "https://picsum.photos/seed/picsum/200/300");
//        data.put("askedCount", "15");
//        arr.add(data);
//        result.put("data", arr);
//
//        data.put("questionid", "8");
//        data.put("title", "test1");
//        data.put("problem", "서버와 통신 가능한지");
//        data.put("tried", "되어야 한다.....");
//        data.put("votes", "10");
//        data.put("views", "8");
//        data.put("answers", "0");
//        data.put("createdAt", null);
//        data.put("modifiedAt", "2023-04-23");
//        data.put("userName", "수진님");
//        data.put("userImage", "https://picsum.photos/seed/picsum/200/300");
//        data.put("askedCount", "15");
//        arr.add(data);
//        result.put("data", arr);
//
//        data.put("questionid", "9");
//        data.put("title", "test1");
//        data.put("problem", "서버와 통신 가능한지");
//        data.put("tried", "되어야 한다.....");
//        data.put("votes", "10");
//        data.put("views", "8");
//        data.put("answers", "0");
//        data.put("createdAt", null);
//        data.put("modifiedAt", "2023-04-23");
//        data.put("userName", "수진님");
//        data.put("userImage", "https://picsum.photos/seed/picsum/200/300");
//        data.put("askedCount", "15");
//        arr.add(data);
//        result.put("data", arr);
//
//        data.put("questionid", "10");
//        data.put("title", "test1");
//        data.put("problem", "서버와 통신 가능한지");
//        data.put("tried", "되어야 한다.....");
//        data.put("votes", "10");
//        data.put("views", "8");
//        data.put("answers", "0");
//        data.put("createdAt", null);
//        data.put("modifiedAt", "2023-04-23");
//        data.put("userName", "수진님");
//        data.put("userImage", "https://picsum.photos/seed/picsum/200/300");
//        data.put("askedCount", "15");
//        arr.add(data);
//        result.put("data", arr);
//
//        data.put("questionid", "11");
//        data.put("title", "test1");
//        data.put("problem", "서버와 통신 가능한지");
//        data.put("tried", "되어야 한다.....");
//        data.put("votes", "10");
//        data.put("views", "8");
//        data.put("answers", "0");
//        data.put("createdAt", null);
//        data.put("modifiedAt", "2023-04-23");
//        data.put("userName", "수진님");
//        data.put("userImage", "https://picsum.photos/seed/picsum/200/300");
//        data.put("askedCount", "15");
//        arr.add(data);
//        result.put("data", arr);
//
//        data.put("questionid", "12");
//        data.put("title", "test1");
//        data.put("problem", "서버와 통신 가능한지");
//        data.put("tried", "되어야 한다.....");
//        data.put("votes", "10");
//        data.put("views", "8");
//        data.put("answers", "0");
//        data.put("createdAt", null);
//        data.put("modifiedAt", "2023-04-23");
//        data.put("userName", "수진님");
//        data.put("userImage", "https://picsum.photos/seed/picsum/200/300");
//        data.put("askedCount", "15");
//        arr.add(data);
//        result.put("data", arr);
//
//        data.put("questionid", "13");
//        data.put("title", "test1");
//        data.put("problem", "서버와 통신 가능한지");
//        data.put("tried", "되어야 한다.....");
//        data.put("votes", "10");
//        data.put("views", "8");
//        data.put("answers", "0");
//        data.put("createdAt", null);
//        data.put("modifiedAt", "2023-04-23");
//        data.put("userName", "수진님");
//        data.put("userImage", "https://picsum.photos/seed/picsum/200/300");
//        data.put("askedCount", "15");
//        arr.add(data);
//        result.put("data", arr);
//
//        data.put("questionid", "14");
//        data.put("title", "test1");
//        data.put("problem", "서버와 통신 가능한지");
//        data.put("tried", "되어야 한다.....");
//        data.put("votes", "10");
//        data.put("views", "8");
//        data.put("answers", "0");
//        data.put("createdAt", null);
//        data.put("modifiedAt", "2023-04-23");
//        data.put("userName", "수진님");
//        data.put("userImage", "https://picsum.photos/seed/picsum/200/300");
//        data.put("askedCount", "15");
//        arr.add(data);
//        result.put("data", arr);
//
//        data.put("questionid", "15");
//        data.put("title", "test1");
//        data.put("problem", "서버와 통신 가능한지");
//        data.put("tried", "되어야 한다.....");
//        data.put("votes", "10");
//        data.put("views", "8");
//        data.put("answers", "0");
//        data.put("createdAt", null);
//        data.put("modifiedAt", "2023-04-23");
//        data.put("userName", "수진님");
//        data.put("userImage", "https://picsum.photos/seed/picsum/200/300");
//        data.put("askedCount", "15");
//        arr.add(data);
//        result.put("data", arr);
//
//        data.put("questionid", "16");
//        data.put("title", "test1");
//        data.put("problem", "서버와 통신 가능한지");
//        data.put("tried", "되어야 한다.....");
//        data.put("votes", "10");
//        data.put("views", "8");
//        data.put("answers", "0");
//        data.put("createdAt", null);
//        data.put("modifiedAt", "2023-04-23");
//        data.put("userName", "수진님");
//        data.put("userImage", "https://picsum.photos/seed/picsum/200/300");
//        data.put("askedCount", "15");
//        arr.add(data);
//        result.put("data", arr);
//
//        data.put("questionid", "17");
//        data.put("title", "test1");
//        data.put("problem", "서버와 통신 가능한지");
//        data.put("tried", "되어야 한다.....");
//        data.put("votes", "10");
//        data.put("views", "8");
//        data.put("answers", "0");
//        data.put("createdAt", null);
//        data.put("modifiedAt", "2023-04-23");
//        data.put("userName", "수진님");
//        data.put("userImage", "https://picsum.photos/seed/picsum/200/300");
//        data.put("askedCount", "15");
//        arr.add(data);
//        result.put("data", arr);
//
//        data.put("questionid", "18");
//        data.put("title", "test1");
//        data.put("problem", "서버와 통신 가능한지");
//        data.put("tried", "되어야 한다.....");
//        data.put("votes", "10");
//        data.put("views", "8");
//        data.put("answers", "0");
//        data.put("createdAt", null);
//        data.put("modifiedAt", "2023-04-23");
//        data.put("userName", "수진님");
//        data.put("userImage", "https://picsum.photos/seed/picsum/200/300");
//        data.put("askedCount", "15");
//        arr.add(data);
//        result.put("data", arr);
//
//        data.put("questionid", "19");
//        data.put("title", "test1");
//        data.put("problem", "서버와 통신 가능한지");
//        data.put("tried", "되어야 한다.....");
//        data.put("votes", "10");
//        data.put("views", "8");
//        data.put("answers", "0");
//        data.put("createdAt", null);
//        data.put("modifiedAt", "2023-04-23");
//        data.put("userName", "수진님");
//        data.put("userImage", "https://picsum.photos/seed/picsum/200/300");
//        data.put("askedCount", "15");
//        arr.add(data);
//        result.put("data", arr);
//
//        data.put("questionid", "20");
//        data.put("title", "test1");
//        data.put("problem", "서버와 통신 가능한지");
//        data.put("tried", "되어야 한다.....");
//        data.put("votes", "10");
//        data.put("views", "8");
//        data.put("answers", "0");
//        data.put("createdAt", null);
//        data.put("modifiedAt", "2023-04-23");
//        data.put("userName", "수진님");
//        data.put("userImage", "https://picsum.photos/seed/picsum/200/300");
//        data.put("askedCount", "15");
//        arr.add(data);
//        result.put("data", arr);
//
//}