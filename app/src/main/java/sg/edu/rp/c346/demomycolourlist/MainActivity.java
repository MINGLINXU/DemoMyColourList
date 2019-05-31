package sg.edu.rp.c346.demomycolourlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText colour;
    EditText position;
    Button btnAddItem;
    ListView lvResult;
    ArrayList<String>alColour;
    ArrayAdapter aaColour;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colour=findViewById(R.id.editTextColour);
        btnAddItem=findViewById(R.id.buttonAddItem);
        lvResult=findViewById(R.id.listViewColour);;
        position=findViewById(R.id.ediposition);


        alColour = new ArrayList<String>();

        alColour.add("Red");
        alColour.add("Orange");

        aaColour = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,alColour);
        lvResult.setAdapter(aaColour);
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = colour.getText().toString();
                int pos = Integer.parseInt(position.getText().toString());
                alColour.add(pos,input);
                aaColour.notifyDataSetChanged();

            }
        });

        lvResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedColour = lvResult.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this,"You click the "+selectedColour+" colour",Toast.LENGTH_SHORT).show();
            }
        });





    }
}
