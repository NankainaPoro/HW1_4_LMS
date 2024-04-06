package g313.vakulenko.hw1_4_lms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText input; // Поле для ввода размера списка
    private Button button; // Кнопка для запуска тестов
    private TextView output; // Поле для вывода результатов
    private int listSize; // Размер списка
    private List<Integer> arrayList = new ArrayList<>(); // Список ArrayList
    private List<Integer> linkedList = new LinkedList<>(); // Список LinkedList

    private long timeOne, timeTwo, timeThree; // Переменные для отсчета времени выполнения операций

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Привязка переменных к элементам интерфейса
        input = findViewById(R.id.input);
        button = findViewById(R.id.button);
        output = findViewById(R.id.output);

        // Установка слушателя на кнопку
        button.setOnClickListener(listener);
    }

    // Слушатель для кнопки
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // Считывание размера списка из поля ввода
            try {
                listSize = Integer.parseInt(input.getText().toString());
            } catch (NumberFormatException numberFormatException) {
                Toast.makeText(MainActivity.this, "Необходимо ввести размер списков в виде числа", Toast.LENGTH_SHORT).show();
            }

            // Замер времени заполнения списков
            timeOne = SystemClock.uptimeMillis();
            arrayList = addList(arrayList);
            timeTwo = SystemClock.uptimeMillis();
            linkedList = addList(linkedList);
            timeThree = SystemClock.uptimeMillis();

            // Вывод времени заполнения списков
            output.setText("Время заполнения ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВремя заполнения LinkedList " + (timeThree - timeTwo) + " мс");

            // Замер времени добавления элементов в начало списков
            timeOne = SystemClock.uptimeMillis();
            arrayList.add(1, 10);
            timeTwo = SystemClock.uptimeMillis();
            linkedList.add(1, 10);
            timeThree = SystemClock.uptimeMillis();
            // Вывод времени добавления элементов в начало списков
            output.append("\n\nВремя добавления элементов:\nВ начало ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВ начало  LinkedList " + (timeThree - timeTwo) + " мс");

            // Замер времени добавления элементов в середину списков
            timeOne = SystemClock.uptimeMillis();
            arrayList.add(listSize / 2, 10);
            timeTwo = SystemClock.uptimeMillis();
            linkedList.add(listSize / 2, 10);
            timeThree = SystemClock.uptimeMillis();
            // Вывод времени добавления элементов в середину списков
            output.append("\nВ середину ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВ середину  LinkedList " + (timeThree - timeTwo) + " мс");

            // Замер времени добавления элементов в конец списков
            timeOne = SystemClock.uptimeMillis();
            arrayList.add(listSize + 1, 10);
            timeTwo = SystemClock.uptimeMillis();
            linkedList.add(listSize + 1, 10);
            timeThree = SystemClock.uptimeMillis();
            // Вывод времени добавления элементов в конец списков
            output.append("\nВ конец ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВ конец  LinkedList " + (timeThree - timeTwo) + " мс");

            // Замер времени замены элементов в начале списков
            timeOne = SystemClock.uptimeMillis();
            arrayList.set(1, 1000);
            timeTwo = SystemClock.uptimeMillis();
            linkedList.set(1, 1000);
            timeThree = SystemClock.uptimeMillis();
            // Вывод времени замены элементов в начале списков
            output.append("\n\nВремя замены элементов:\nВ начале ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВ начале  LinkedList " + (timeThree - timeTwo) + " мс");

            // Замер времени замены элементов в середине списков
            timeOne = SystemClock.uptimeMillis();
            arrayList.set(listSize / 2, 1000);
            timeTwo = SystemClock.uptimeMillis();
            linkedList.set(listSize / 2, 1000);
            timeThree = SystemClock.uptimeMillis();
            // Вывод времени замены элементов в середине списков
            output.append("\nВ середине ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВ середине  LinkedList " + (timeThree - timeTwo) + " мс");

            // Замер времени замены элементов в конце списков
            timeOne = SystemClock.uptimeMillis();
            arrayList.set(listSize, 1000);
            timeTwo = SystemClock.uptimeMillis();
            linkedList.set(listSize, 1000);
            timeThree = SystemClock.uptimeMillis();
            // Вывод времени замены элементов в конце списков
            output.append("\nВ конце ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВ конце  LinkedList " + (timeThree - timeTwo) + " мс");

            // Замер времени удаления элементов в начале списков
            timeOne = SystemClock.uptimeMillis();
            arrayList.remove(1);
            timeTwo = SystemClock.uptimeMillis();
            linkedList.remove(1);
            timeThree = SystemClock.uptimeMillis();
            // Вывод времени удаления элементов в начале списков
            output.append("\n\nВремя удаления элементов:\nВ начале ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВ начале  LinkedList " + (timeThree - timeTwo) + " мс");

            // Замер времени удаления элементов в середине списков
            timeOne = SystemClock.uptimeMillis();
            arrayList.remove(listSize / 2);
            timeTwo = SystemClock.uptimeMillis();
            linkedList.remove(listSize / 2);
            timeThree = SystemClock.uptimeMillis();
            // Вывод времени удаления элементов в середине списков
            output.append("\nВ середине ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВ середине  LinkedList " + (timeThree - timeTwo) + " мс");

            // Замер времени удаления элементов в конце списков
            timeOne = SystemClock.uptimeMillis();
            arrayList.remove(listSize);
            timeTwo = SystemClock.uptimeMillis();
            linkedList.remove(listSize);
            timeThree = SystemClock.uptimeMillis();
            // Вывод времени удаления элементов в конце списков
            output.append("\nВ конце ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВ конце  LinkedList " + (timeThree - timeTwo) + " мс");
        }
    };

    // Метод для заполнения списка числами арифметической прогрессии на 10
    private List<Integer> addList(List<Integer> list) {
        int currentNumber = 0; // Начальное значение для арифметической прогрессии

        // Заполнение списка значениями арифметической прогрессии на 10
        for (int i = 0; i < listSize; i++) {
            list.add(currentNumber);
            currentNumber += 10; // Увеличение текущего числа на 10 для получения следующего числа в прогрессии
        }
        return list;
    }
}