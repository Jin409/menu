package menu.model;

public class FoodHistory {
    private final Coach coach;
    private final Food food;
    private final Day day;

    public FoodHistory(Coach coach, Food food, Day day) {
        this.coach = coach;
        this.food = food;
        this.day = day;
    }

    public boolean hasAlreadyEaten(Food food) {
        return this.food.equals(food);
    }

    public boolean belongsTo(Coach comparedCoach) {
        return this.coach.equals(comparedCoach);
    }

    public boolean recordedAt(Day day) {
        return this.day == day;
    }

    public String getCoachName() {
        return coach.getName();
    }

    public String getFoodName() {
        return food.getName();
    }
}
