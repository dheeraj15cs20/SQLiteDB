package com.example.adc.sqlite;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Name, Pass, updateold, updatenew, delete;
    myDbAdapter helper=new  myDbAdapter(this);
    Message message=new Message();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name=(EditText) findViewById(R.id.editName);
        Pass=(EditText) findViewById(R.id.editPass);
        updateold=(EditText)findViewById(R.id.editText3);
        updatenew=(EditText)findViewById(R.id.editText5);
        delete=(EditText)findViewById(R.id.editText6);



    }
    public  void addUser(View view){
        String t1= Name.getText().toString();
        String t2=Pass.getText().toString();
       // com.example.adc.sqlite.Message.message(getApplicationContext(),"enter both name and password");
        if(t1.isEmpty()||t2.isEmpty()) {

            com.example.adc.sqlite.Message.message(getApplicationContext(), "enter both name and password");
        } else
        {
            long id=helper.insertData(t1,t2);
            if(id<=0){

                com.example.adc.sqlite.Message.message(getApplicationContext(),"Insertion unsuccessful");
                Name.setText("");
                Pass.setText("");
            }
            else
            {
                com.example.adc.sqlite.Message.message(getApplicationContext(),"Insertion Successful");
                Name.setText("");
                Pass.setText("");
            }

        }
    }
    public void viewdata(View view){
        String data= helper.getData();
        com.example.adc.sqlite.Message.message(this,data);
    }
    public void update( View view)
    {
        String u1 = updateold.getText().toString();
        String u2 = updatenew.getText().toString();
        if(u1.isEmpty() || u2.isEmpty())
        {
            com.example.adc.sqlite.Message.message(getApplicationContext(),"Enter Data");
        }
        else
        {
            int a= helper.updateName( u1, u2);
            if(a<=0)
            {
                com.example.adc.sqlite.Message.message(getApplicationContext(),"Unsuccessful");
                updateold.setText("");
                updatenew.setText("");
            } else {
                com.example.adc.sqlite.Message.message(getApplicationContext(),"Updated");
                updateold.setText("");
                updatenew.setText("");
            }
        }
    }

    private int helperupdateName(String u1, String u2) {
        return 0;
    }

    public void delete(View view){
        String uname=delete.getText().toString();
        if (uname.isEmpty())
        {
            com.example.adc.sqlite.Message.message(getApplicationContext(),"Enter data");
        }
        else{
            int a=helper.delete(uname);
            if(a<=0)
            {
                com.example.adc.sqlite.Message.message(getApplicationContext(),"Unsuccessfull");
                delete.setText("");
            }
            else
            {
                com.example.adc.sqlite.Message.message(this,"Deleted");
                delete.setText("");
            }
        }
    }
}
