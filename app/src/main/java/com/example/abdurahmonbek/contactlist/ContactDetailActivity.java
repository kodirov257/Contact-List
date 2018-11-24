package com.example.abdurahmonbek.contactlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactDetailActivity extends AppCompatActivity {

    private TextView contactId, fullName, contactNumber;
    private ImageView contactPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        init();

        Intent intent = getIntent();

        contactId.setText(intent.getStringExtra("ContactId"));
        fullName.setText(intent.getStringExtra("FullName"));
        contactNumber.setText(intent.getStringExtra("ContactNumber"));
        contactPhoto.setImageResource(intent.getIntExtra("ContactPhoto", R.drawable.contact_128));
    }

    private void init() {
        contactId = (TextView) findViewById(R.id.contact_id_text_view);
        fullName = (TextView) findViewById(R.id.full_name_text_view);
        contactNumber = (TextView) findViewById(R.id.contact_number_text_view);
        contactPhoto = (ImageView) findViewById(R.id.contact_photo_image_view);
    }
}
