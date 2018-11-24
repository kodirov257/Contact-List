package com.example.abdurahmonbek.contactlist.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abdurahmonbek.contactlist.Contact;
import com.example.abdurahmonbek.contactlist.R;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Contact> {

    public CustomAdapter(Context context, int resource, ArrayList<Contact>contacts) {
        super(context, resource, contacts);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Contact contact = getItem(position);
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.model, parent, false);
            holder.fullName = (TextView)convertView.findViewById(R.id.full_name);
            holder.contactNumber = (TextView)convertView.findViewById(R.id.contact_number);
            holder.contactImageView = (ImageView)convertView.findViewById(R.id.contact_image);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        assert contact != null;
        holder.fullName.setText(contact.getFullName());
        holder.contactNumber.setText(String.valueOf(contact.getContactNumber()));
        holder.contactImageView.setImageResource(R.drawable.contact_64);

        return convertView;
    }

    private static class ViewHolder {
        TextView fullName;
        TextView contactNumber;
        ImageView contactImageView;
    }
}
