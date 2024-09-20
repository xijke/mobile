import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Убедитесь, что layout файл существует и его имя правильно

        // Пример использования TextView
        TextView bookTitle = findViewById(R.id.book_title);
        bookTitle.setText("Fahrenheit 451");
    }
}

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    // Индекс текущей книги
    private int currentBookIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Пример списка книг
        String[] bookTitles = {"Fahrenheit 451", "1984", "Brave New World"};
        String[] bookAuthors = {"Ray Bradbury", "George Orwell", "Aldous Huxley"};
        String[] bookDescriptions = {
                "Fahrenheit 451 is a science fiction dystopian novel...",
                "1984 is a dystopian social science fiction novel...",
                "Brave New World is a dystopian social science fiction novel..."
        };

        // Обработчики кнопок навигации между книгами
        findViewById(R.id.btn_previous).setOnClickListener(v -> {
            if (currentBookIndex > 0) {
                currentBookIndex--;
                updateBookInfo(bookTitles, bookAuthors, bookDescriptions);
            }
        });

        findViewById(R.id.btn_next).setOnClickListener(v -> {
            if (currentBookIndex < bookTitles.length - 1) {
                currentBookIndex++;
                updateBookInfo(bookTitles, bookAuthors, bookDescriptions);
            }
        });

        // Нижняя панель навигации
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_my_books:
                        // Обработайте переход в "My books"
                        return true;
                    case R.id.nav_library:
                        // Обработайте переход в "Library"
                        return true;
                    case R.id.nav_profile:
                        // Обработайте переход в "Profile"
                        return true;
                }
                return false;
            }
        });

        // Инициализируем информацию о книге
        updateBookInfo(bookTitles, bookAuthors, bookDescriptions);
    }

    private void updateBookInfo(String[] titles, String[] authors, String[] descriptions) {
        // Обновляем информацию о книге на экране
        TextView bookTitle = findViewById(R.id.book_title);
        TextView bookAuthor = findViewById(R.id.book_author);
        TextView bookDescription = findViewById(R.id.book_description);

        bookTitle.setText(titles[currentBookIndex]);
        bookAuthor.setText(authors[currentBookIndex]);
        bookDescription.setText(descriptions[currentBookIndex]);
    }
}
