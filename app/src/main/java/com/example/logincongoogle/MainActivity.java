package com.example.logincongoogle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    CircleImageView img;
    TextView tv1,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        img = findViewById(R.id.image1);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        if (user!=null){
            String name=user.getDisplayName();
            String gmail=user.getEmail();

            tv1.setText("Usuario  " + name  );
            tv2.setText(" Email " + gmail);
            Picasso.get().load(user.getPhotoUrl()).placeholder(R.drawable.loginn).into(img);
        }else {
            getApplicationContext();

        }
    }
    public void serra(View view){
        FirebaseAuth.getInstance().signOut();
        finish();
    }
}