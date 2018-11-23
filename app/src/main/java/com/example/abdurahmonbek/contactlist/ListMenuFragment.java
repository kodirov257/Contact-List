package com.example.abdurahmonbek.contactlist;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ListMenuFragment extends ListFragment {

    private ArrayList<Contact>contacts;
    private ArrayList<HashMap<String, String>>data;
    private SimpleAdapter adapter;


//    private String[] contact_images = new String[]{"benz", "bike", "car", "carrera", "ferrari", "harly", "lamborghini", "silver"};
//    private String[] id = new String[]{"frank_lampard", "john_terry", "steven_king", "ricardo_kaka", "petr_cech", "eden_hazaard", "markos_alonso", "christopher_nolan"};
//    private String[] nameList = new String[]{"Frank", "John", "Steven", "Ricardo", "Petr", "Eden", "Markos", "Christopher"};
//    private String[] surnameList = new String[]{"Lampard", "Terry", "King", "Kaka", "Cech", "Hazaard", "Alonso", "Nolan"};
//    private int[] contact_number = new int[]{};

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contact_list, container, false);

        contacts = populateList();

        HashMap<String, String>map;

        for (int i = 0; i < contacts.size(); i++) {
            map = new HashMap<String, String>();
            map.put("FullName", contacts.get(i).getFullName());
            map.put("ContactNumber", String.valueOf(contacts.get(i).getContactNumber()));
            map.put("Image", Integer.toString(getResources().getIdentifier(contacts.get(i).getImageName(), "drawable", (new MainActivity()).getPackageName())));

            data.add(map);
        }

        // Keys in hash map
        String[] from = {"FullName", "ContactNumber", "Image"};
        // ids of views
        int[] to = {R.id.full_name, R.id.contact_number, R.id.contact_image};

        adapter = new SimpleAdapter(getActivity(), data, R.layout.model, from, to);
        setListAdapter(adapter);

        return view;
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(MainActivity.this, ContactDetailActivity.class);
        intent.putExtra("ContactId", contacts.get(position).getId());
        intent.putExtra("FullName", contacts.get(position).getFullName());
        intent.putExtra("ContactNumber", contacts.get(position).getContactNumber());
        intent.putExtra("ContactPhoto", contacts.get(position).getImageName());

        startActivity(intent);
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
