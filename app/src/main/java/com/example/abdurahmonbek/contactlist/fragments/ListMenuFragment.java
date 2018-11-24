package com.example.abdurahmonbek.contactlist.fragments;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.abdurahmonbek.contactlist.Contact;
import com.example.abdurahmonbek.contactlist.ContactDetailActivity;
import com.example.abdurahmonbek.contactlist.adapters.CustomAdapter;
import com.example.abdurahmonbek.contactlist.R;

import java.util.ArrayList;
import java.util.Scanner;

public class ListMenuFragment extends ListFragment {

    private ArrayList<Contact>contacts;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contact_list, container, false);

        contacts = populateList();

        CustomAdapter adapter = new CustomAdapter(getActivity(), R.layout.model, contacts);

        setListAdapter(adapter);

        return view;
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            assert getFragmentManager() != null;
            ContactDetailsFragment contactDetails = (ContactDetailsFragment) getFragmentManager().findFragmentById(R.id.detail_fragment);
            assert contactDetails != null;
            contactDetails.change(contacts.get(position).getFullName(), String.valueOf(contacts.get(position).getContactNumber()), R.drawable.contact_128);
            getListView().setSelector(android.R.color.holo_blue_light);
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            Intent intent = new Intent(getActivity(), ContactDetailActivity.class);
            intent.putExtra("ContactId", contacts.get(position).getId());
            intent.putExtra("FullName", contacts.get(position).getFullName());
            intent.putExtra("ContactNumber", String.valueOf(contacts.get(position).getContactNumber()));
            intent.putExtra("ContactPhoto", R.drawable.contact_128);

            startActivity(intent);
        }
    }

    private ArrayList<Contact> populateList() {
        ArrayList<Contact>list = new ArrayList<>();
        Scanner scanner = new Scanner(getResources().openRawResource(R.raw.info));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] temp = line.split(" ");
            Contact contact = new Contact(temp[0], temp[1], temp[2], temp[3], Integer.parseInt(temp[4]));
            list.add(contact);
        }
        return list;
    }
}
