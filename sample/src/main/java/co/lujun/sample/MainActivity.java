package co.lujun.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import co.lujun.androidtagview.ColorFactory;
import co.lujun.androidtagview.TagContainerLayout;
import co.lujun.androidtagview.TagView;

public class MainActivity extends AppCompatActivity {

    private TagContainerLayout mTagContainerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTagContainerLayout = (TagContainerLayout) findViewById(R.id.tagcontainerLayout);
        mTagContainerLayout.setOnTagClickListener(new TagView.OnTagClickListener() {
            @Override
            public void onTagClick(int position, String text) {
                Toast.makeText(MainActivity.this, "position:" + position + ", text:" + text,
                        Toast.LENGTH_SHORT).show();
            }
        });
        List<String> list = new ArrayList<String>();
        list.add("Java");
        list.add("C/C++");
        list.add("Python");
        list.add("Swift");
        list.add("你好，这是一个TAG。你好，这是一个TAG。你好，这是一个TAG。你好，这是一个TAG。");
        list.add("PHP");
        list.add("Python");
        list.add("JavaScript");
        list.add("Html");
        list.add("Hello, this is a TAG example.");
        list.add("Welcome to use AndroidTagView!");

        // Custom settings
//        mTagContainerLayout.setTagMaxLength(4);

        // Set the custom theme
//        mTagContainerLayout.setTheme(ColorFactory.PURE_CYAN);

        // If you want to use your colors for TagView, remember set the theme with ColorFactory.NONE
//        mTagContainerLayout.setTheme(ColorFactory.NONE);
//        mTagContainerLayout.setTagBackgroundColor(Color.TRANSPARENT);

        // After you set your own attributes for TagView, then set tag(s) or add tag(s)
        mTagContainerLayout.setTags(list);

        Button btnAddTag = (Button) findViewById(R.id.btn_add_tag);
        btnAddTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTagContainerLayout.addTag("This is a TAG u added!");
//                mTagContainerLayout.addTag("This is a TAG u added!", 4);
            }
        });
        Button btnRemoveTag = (Button) findViewById(R.id.btn_remove_tag);
        btnRemoveTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTagContainerLayout.removeTag(5);
            }
        });
    }
}
