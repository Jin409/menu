package menu.model;

public class FoodHistory {
    private final Coach coach;
    private final Food food;

    public FoodHistory(Coach coach, Food food) {
        this.coach = coach;
        this.food = food;
    }

    public boolean hasAlreadyEaten(Food food) {
        return this.food.equals(food);
    }

    public boolean belongsTo(Coach comparedCoach) {
        return this.coach.equals(comparedCoach);
    }
}
