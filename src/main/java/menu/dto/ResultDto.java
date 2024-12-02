package menu.dto;

import java.util.List;

public class ResultDto {
    private final String day;
    private final String category;
    private final List<FoodHistoryDto> foodHistoryDtos;

    public ResultDto(String day, String category, List<FoodHistoryDto> foodHistoryDtos) {
        this.day = day;
        this.category = category;
        this.foodHistoryDtos = foodHistoryDtos;
    }

    public String getDay() {
        return day;
    }

    public String getCategory() {
        return category;
    }

    public List<FoodHistoryDto> getFoodHistoryDtos() {
        return foodHistoryDtos;
    }

    public static class FoodHistoryDto {
        private final String coachName;
        private final String foodName;

        public FoodHistoryDto(String coachName, String foodName) {
            this.coachName = coachName;
            this.foodName = foodName;
        }

        public String getCoachName() {
            return coachName;
        }

        public String getFoodName() {
            return foodName;
        }
    }

}
