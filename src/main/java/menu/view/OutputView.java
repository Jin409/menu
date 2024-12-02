package menu.view;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.dto.ResultDto;
import menu.dto.ResultDto.FoodHistoryDto;

public class OutputView {
    public static void displayStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public static void displayResult(List<ResultDto> dtos) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println(formatDays(dtos));
        System.out.println(formatCategories(dtos));
        List<String> formatFoodHistories = formatFoodHistories(dtos);
        formatFoodHistories.forEach(System.out::println);

        System.out.println("추천을 완료했습니다.");
    }

    private static String formatDays(List<ResultDto> dtos) {
        StringBuilder output = new StringBuilder("[ 구분");
        for (ResultDto dto : dtos) {
            output.append(" | ").append(dto.getDay());
        }
        return output + " ]";
    }

    private static String formatCategories(List<ResultDto> dtos) {
        StringBuilder output = new StringBuilder("[ 카테고리");
        for (ResultDto dto : dtos) {
            output.append(" | ").append(dto.getCategory());
        }
        return output + " ]";
    }

    private static List<String> formatFoodHistories(List<ResultDto> dtos) {
        Map<String, List<String>> groupedByCoachName = new HashMap<>();

        for (ResultDto dto : dtos) {
            List<FoodHistoryDto> foodHistoryDtos = dto.getFoodHistoryDtos();
            for (FoodHistoryDto foodHistoryDto : foodHistoryDtos) {
                String coachName = foodHistoryDto.getCoachName();
                if (groupedByCoachName.containsKey(coachName)) {
                    List<String> foodNames = groupedByCoachName.get(coachName);
                    foodNames.add(foodHistoryDto.getFoodName());
                    continue;
                }
                groupedByCoachName.put(coachName, new ArrayList<>(List.of(foodHistoryDto.getFoodName())));

            }
        }

        List<String> coachNames = new ArrayList<>();
        List<FoodHistoryDto> foodHistoryDtos = dtos.get(0).getFoodHistoryDtos();
        for (FoodHistoryDto foodHistoryDto : foodHistoryDtos) {
            coachNames.add(foodHistoryDto.getCoachName());
        }

        List<String> results = new ArrayList<>();
        for (String coachName : coachNames) {
            StringBuilder result = new StringBuilder("[ " + coachName);
            for (String foodName : groupedByCoachName.get(coachName)) {
                result.append(" | ").append(foodName);
            }
            results.add(result + " ]");
        }

        return results;
    }
}
