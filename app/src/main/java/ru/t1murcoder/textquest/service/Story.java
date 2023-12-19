package ru.t1murcoder.textquest.service;

import ru.t1murcoder.textquest.domain.Situation;

public class Story {
    private Situation start_story;
    public Situation current_situation;

    public Story() {

    }

    public void go(int num) {
        if (num <= current_situation.direction.length)
            current_situation = current_situation.direction[num - 1];
        else
            System.out.println("Вы можете выбирать из "
                    + current_situation.direction.length + " вариантов");
    }

    public boolean isEnd() {
        return current_situation.direction.length == 0;
    }
}
