package ru.t1murcoder.textquest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ru.t1murcoder.textquest.databinding.ActivityMainBinding;
import ru.t1murcoder.textquest.domain.Country;
import ru.t1murcoder.textquest.service.Story;

public class MainActivity extends AppCompatActivity {
    public static Country country = new Country();
    public static Story story = new Story();
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        country = new Country();
//        story = new Story();

        country.Happiness += story.current_situation.dHappiness;
        country.Population += story.current_situation.dPopulation;
        country.Money += story.current_situation.dMoney;

        binding.tvHappiness.setText("Happiness:" + String.valueOf(country.Happiness));
        binding.tvPopulation.setText("Population:" + String.valueOf(country.Population));
        binding.tvMoney.setText("Money:" + String.valueOf(country.Money));

        binding.tvSituation.setText(story.current_situation.text);

        binding.btnFirst.setOnClickListener(new MyListener());
        binding.btnSecond.setOnClickListener(new MyListener());
    }

    class MyListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (story.isEnd()) {
                Toast.makeText(MainActivity.this, "Story is end!", Toast.LENGTH_SHORT).show();
            } else {
                country.Happiness += story.current_situation.dHappiness;
                country.Population += story.current_situation.dPopulation;
                country.Money += story.current_situation.dMoney;

                binding.tvHappiness.setText("Happiness:" + String.valueOf(country.Happiness));
                binding.tvPopulation.setText("Population:" + String.valueOf(country.Population));
                binding.tvMoney.setText("Money:" + String.valueOf(country.Money));

                binding.tvSituation.setText(story.current_situation.text);


                if (((Button) view).getText().toString().equals("Да")) {
                    story.go(1);
                } else {
                    story.go(2);
                }
            }
        }
    }

}