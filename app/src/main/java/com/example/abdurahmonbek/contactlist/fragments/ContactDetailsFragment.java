package com.example.abdurahmonbek.contactlist.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abdurahmonbek.contactlist.R;

public class ContactDetailsFragment extends Fragment {

    private TextView fullName, contactNumber;
    private ImageView contactsImage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contact_detail, container, false);

        fullName = (TextView) view.findViewById(R.id.full_name_text_view_fragment);
        contactNumber = (TextView) view.findViewById(R.id.contact_number_text_view_fragment);
        contactsImage = (ImageView) view.findViewById(R.id.contact_image_fragment);

        return view;
    }

    public void change(String fname, String cnumber, int cimage) {
        fullName.setText(fname);
        contactNumber.setText(cnumber);
        contactsImage.setImageResource(cimage);
    }
}
