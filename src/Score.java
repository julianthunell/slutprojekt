public class Score <T> {
    //This could work for any type of variable, Right now unnessearcy since
    //only ints are used, but useful for future.
    T highScore;
    public Score(T inputScore){
        highScore = inputScore;

    }
    //Checks if inputed score is higher than current high score
    public void updateHighScore(T newInputScore){
        if ((int)newInputScore > (int)highScore){
            highScore = newInputScore;
        }
    }
    //Getter
    public T get(){
        return highScore;
    }

}
