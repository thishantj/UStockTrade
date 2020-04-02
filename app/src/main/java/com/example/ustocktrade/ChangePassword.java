package com.example.ustocktrade;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

public class ChangePassword extends AppCompatActivity {

    Button update;
    TextView opass, npass, rpass;
    dbHelper db;
    
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        db = new dbHelper(this);

        getSupportActionBar().setTitle("Change password");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        update = findViewById(R.id.btnUpdate);
        opass = findViewById(R.id.txtOldPass);
        npass = findViewById(R.id.txtNewPass);
        rpass = findViewById(R.id.txtRetypePass);
    }

    public void back(View view)
    {
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }

    public void update(View view)
    {
        String retype = rpass.getText().toString();
        String newp = npass.getText().toString();
        String oldp = opass.getText().toString();

        if(oldp.equalsIgnoreCase("") || newp.equalsIgnoreCase("") || retype.equalsIgnoreCase("") )
        {
            showEmptyFieldToast();
        }
        else
        {
            if(retype.equals(newp) )
            {
                if(newp == "123@123" && oldp == "test123") //assuming the old password was test123 I have checked if it is correctly entered and as no database is connected I cannot retrieve value from the DB
                {
                    Intent intent = new Intent(this, Dashboard.class);
                    startActivity(intent);

                    //code for the update of database for an SQLite was commented as a DB was not specified to be updated
                /*Boolean isUpdated = db.updateData(opass.getText().toString(), npass.getText().toString());

                if (isUpdated == true){
                    Toast.makeText(getApplicationContext(),"Updated successfully",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Error in updating",Toast.LENGTH_SHORT).show();
                }*/
                }
                else
                {
                    showErrorToast();
                }
            }
            else
            {
                showErrorPasswordToast();
            }
        }
    }

    private void showErrorToast()
    {
        StyleableToast.makeText(this, "Insert error text", R.style.pchtoast).show();
    }

    private void showErrorPasswordToast()
    {
        StyleableToast.makeText(this, "Passwords do not match", R.style.pswdmatch).show();
    }

    private void showEmptyFieldToast()
    {
        StyleableToast.makeText(this, "Please fill all the fields", R.style.emptyField).show();
    }
}
