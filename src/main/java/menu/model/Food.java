package menu.model;

import java.util.Arrays;

public enum Food {
    규동(Category.JAPANESE, "규동"),
    우동(Category.JAPANESE, "우동"),
    미소시루(Category.JAPANESE, "미소시루"),
    스시(Category.JAPANESE, "스시"),
    오니기리(Category.JAPANESE, "오니기리"),
    하이라이스(Category.JAPANESE, "하이라이스"),
    라멘(Category.JAPANESE, "라멘"),
    오코노미야끼(Category.JAPANESE, "오코노미야끼"),

    김밥(Category.KOREAN, "김밥"),
    김치찌개(Category.KOREAN, "김치찌개"),
    쌈밥(Category.KOREAN, "쌈밥"),
    된장찌개(Category.KOREAN, "된장찌개"),
    비빔밥(Category.KOREAN, "비빔밥"),
    칼국수(Category.KOREAN, "칼국수"),
    불고기(Category.KOREAN, "불고기"),
    떡볶이(Category.KOREAN, "떡볶이"),
    제육볶음(Category.KOREAN, "제육볶음"),

    깐풍기(Category.CHINESE, "깐풍기"),
    볶음면(Category.CHINESE, "볶음면"),
    동파육(Category.CHINESE, "동파육"),
    짜장면(Category.CHINESE, "짜장면"),
    짬뽕(Category.CHINESE, "짬뽕"),
    마파두부(Category.CHINESE, "마파두부"),
    탕수육(Category.CHINESE, "탕수육"),
    토마토_달걀볶음(Category.CHINESE, "토마토 달걀볶음"),
    고추잡채(Category.CHINESE, "고추잡채"),

    팟타이(Category.ASIAN, "팟타이"),
    카오_팟(Category.ASIAN, "카오 팟"),
    나시고렝(Category.ASIAN, "나시고렝"),
    파인애플_볶음밥(Category.ASIAN, "파인애플 볶음밥"),
    쌀국수(Category.ASIAN, "쌀국수"),
    똠얌꿍(Category.ASIAN, "똠얌꿍"),
    반미(Category.ASIAN, "반미"),
    월남쌈(Category.ASIAN, "월남쌈"),
    분짜(Category.ASIAN, "분짜"),

    라자냐(Category.WESTERN, "라자냐"),
    그라탱(Category.WESTERN, "그라탱"),
    뇨끼(Category.WESTERN, "뇨끼"),
    끼슈(Category.WESTERN, "끼슈"),
    프렌치_토스트(Category.WESTERN, "프렌치 토스트"),
    바게트(Category.WESTERN, "바게트"),
    스파게티(Category.WESTERN, "스파게티"),
    피자(Category.WESTERN, "피자"),
    파니니(Category.WESTERN, "파니니"),

    ;

    private final Category category;
    private final String name;

    Food(Category category, String name) {
        this.category = category;
        this.name = name;
    }

    public static Food findByName(String comparedName) {
        return Arrays.stream(Food.values())
                .filter(f -> f.name.equals(comparedName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 음식입니다."));
    }
}
