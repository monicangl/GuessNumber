package com.github.monicangl.tdd.guessnumber;

import java.util.List;

public class GuessNumberGame {
 //   private AnswerGenerator numberGenerator;
//    private GuessNumberGameHandler gameHandler;
//    private GuessRecord guessRecord;
//    private NumbersValidator validator = new NumbersValidator();
    private List<Integer> answer;
    private GameHistory history;

    public GuessNumberGame(List<Integer> answer) {
//        numberGenerator = new AnswerGenerator();
//        guessRecord = new GuessRecord();
//        gameHandler = new GuessNumberGameHandler(numberGenerator.generate());
        //answer = generateAnswer();
        this.answer = answer;
        history = new GameHistory();
    }

//    public List<String> guessRecord() {
//        return guessRecord.getRecord();
//    }

//    public String guess(List<Integer> guessNumbers) {
//        if (!validator.validate(guessNumbers)) {
//            guessRecord.addRecord(guessNumbers, "输入不正确，重新输入");
//            return "输入不正确，重新输入";
//        }
//
//        String result = gameHandler.handle(guessNumbers);
//        guessRecord.addRecord(guessNumbers, result);
//        return result;
//    }
//
//    public void setNumbers(List<Integer> numbers) {
//        this.gameHandler.setNumbers(numbers);
//    }

    public String play(List<Integer> numbers) {
        String result;
        if (numbers.equals(answer)) {
            result = "0A4B";
        }
        else {
            int rightPositionNumberCount = 0;
            int wrongPositionNumberCount = 0;

            for (int i = 0; i < numbers.size(); ++i) {
                if (this.answer.contains(numbers.get(i))) {
                    if (numbers.get(i).equals(this.answer.get(i))) {
                        ++rightPositionNumberCount;
                    } else {
                        ++wrongPositionNumberCount;
                    }
                }
            }

            result = rightPositionNumberCount + "A" + wrongPositionNumberCount + "B";
        }

        history.addRecord(new GameRecord(numbers, result));

        return result;
    }

//    private List<Integer> generateAnswer() {
//        return null;
//    }

    public String promptError() {
        return "输入不正确，重新输入";
    }

    public GameHistory getHistory() {
        return history;
    }

    public void newGame() {
        history.clearRecord();
    }
}
