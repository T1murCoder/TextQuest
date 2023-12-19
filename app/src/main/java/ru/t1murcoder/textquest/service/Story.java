package ru.t1murcoder.textquest.service;

import ru.t1murcoder.textquest.domain.Situation;

public class Story {
    private Situation start_story;
    public Situation current_situation;

    public Story() {
        start_story = new Situation(
                "Вас стукнули по голове, вы очнулись и к вам подошел дворецкий." +
                        "Он сказал что вы новый президент России! И что сейчас 2083." + "В мире давно была атомная война, половина городов вымерла, но некоторые остались."
                        + "А уже прямо сейчас Вам надо принимать решения по развитию государства!" + "\nВ городе человек заболел ковидом, следует ли проверить город и изолировать заболевших?",
                2, 0, 0, 0);

        // первый уровень
        start_story.direction[0] = new Situation(
                "Населению понравилась ваша забота, но вы потратили много денег." + "\nСтоит ли повысить налоги?",
                2, 10, 0, -15);
        start_story.direction[1] = new Situation(
                "Людям не нравиться, что выходить на улицу опасно" + "\nПоступил анонимный звонок. Ваша жизнь может быть в опасности. Усилить охрану?",
                2, -20, -25, 0);
        // второй уровень
        start_story.direction[0].direction[0] = new Situation(
                "Вы повысили налоги, населению не понравилось. Вашему государству прибавились деньги" + "\nХотите ли вы потратить эти деньги на улучшение образования?",
                2, -5, 0, 15
        );
        start_story.direction[0].direction[1] = new Situation(
                "Страну настиг кризис, вы находитесь в упадке. Страна обратилась в хаос",
                0, -10000, -1000, -1000
        );

        start_story.direction[1].direction[0] = new Situation(
                "Вы усилили охрану, тем самым предотвратили покушение на себя. Вы живы" + "\nИз-за эпидемии начался криминальный беспорядок. Выделить ли деньги на поддержку правохранительных органов?",
                0, -10, -10, -10
        );
        start_story.direction[1].direction[1] = new Situation(
                "Вы отказались от охраны, на вас было совершено покушение в ходе которого вас убили. Вы мертвы",
                0, 0, 0, -10
        );
        // третий уровень
        start_story.direction[0].direction[0].direction[0] = new Situation(
                "Государство выделило деньги на образование. Ваша страна процветает" + "\nХотите ли вы расширить территорию, тем самым объявив войну соседнему государству?",
                0, 10, 5, 15
        );
        start_story.direction[0].direction[0].direction[1] = new Situation(
                "Ваша страна погрязла в безграмотности. Люди вернулись к первобытному строю. На улицах воццарился хаос",
                0, -1000, -1000, -1000
        );
        start_story.direction[1].direction[0].direction[0] = new Situation(
                "Вы веделили деньги на поддержку правохранительных органов. У вашего государства не осталось денег",
                0, 20, 10, -100
        );
        start_story.direction[1].direction[0].direction[1] = new Situation(
                "Народ крайне не доволен, люди вас свергли. Вы мертвы",
                0, -100, -100, 0
        );
        // четвертый уровень
        start_story.direction[0].direction[0].direction[0].direction[0] = new Situation(
                "Вы захватили соседнее государство, но с огромными потерями. У вас не осталось людей, для того чтобы контроллировать ваши земли. Государство на грани распада",
                0, -40, -50, -50
        );
        start_story.direction[0].direction[0].direction[0].direction[1] = new Situation(
                "Вы отказались расширять территории и из-за этого на ваших землях перенаселение",
                0, -15, 30, 0
        );

        current_situation = start_story;
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
