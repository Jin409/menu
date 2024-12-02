package menu.service;

import java.util.ArrayList;
import java.util.List;
import menu.dto.ResultDto;
import menu.dto.ResultDto.FoodHistoryDto;
import menu.model.CategoryHistory;
import menu.model.Day;
import menu.model.Food;
import menu.model.FoodHistory;
import menu.model.repository.CategoryHistoryRepository;
import menu.model.repository.FoodHistoryRepository;

public class HistoryService {
    private final FoodHistoryRepository foodHistoryRepository;
    private final CategoryHistoryRepository categoryHistoryRepository;

    public HistoryService(FoodHistoryRepository foodHistoryRepository,
                          CategoryHistoryRepository categoryHistoryRepository) {
        this.foodHistoryRepository = foodHistoryRepository;
        this.categoryHistoryRepository = categoryHistoryRepository;
    }

    public List<ResultDto> getResults() {
        List<ResultDto> results = new ArrayList<>();
        for (Day day : Day.values()) {
            CategoryHistory categoryHistory = categoryHistoryRepository.findByDay(day);
            List<FoodHistory> foodHistories = foodHistoryRepository.findByDay(day);
            results.add(
                    new ResultDto(day.name(), categoryHistory.getCategoryName(), getFoodHistoryDtos(foodHistories)));
        }
        return results;
    }

    private List<FoodHistoryDto> getFoodHistoryDtos(List<FoodHistory> histories) {
        List<FoodHistoryDto> foodHistoriesDtos = new ArrayList<>();
        for (FoodHistory history : histories) {
            foodHistoriesDtos.add(new FoodHistoryDto(history.getCoachName(), history.getFoodName()));
        }
        return foodHistoriesDtos;
    }
}
