package com.example.testcontactlist;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ContactManager {
    private Context mContext;
    private ArrayList<ContactModel> contactModelsList;

    public ContactManager(Context context) {
        mContext = context;
        getContactData();
        Collections.sort(contactModelsList);
    }

    public ArrayList<ContactModel> getContactModelsList() {
        return contactModelsList;
    }

    private void getContactData() {
        contactModelsList = new ArrayList<>();
        String[] data = {
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.CommonDataKinds.Phone.PHOTO_URI
        };
        Cursor phones = mContext.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, data, null, null, null);
        int nameIndex = phones.getColumnIndex(data[0]);
        int numberIndex = phones.getColumnIndex(data[1]);
        int photoIndex = phones.getColumnIndex(data[2]);
        phones.moveToFirst();
        while (phones.moveToNext()) {
            String name = phones.getString(nameIndex);
            String number = phones.getString(numberIndex);
            String photoUri = phones.getString(photoIndex);
            Bitmap photo = getPhotoFromUri(photoUri);
            contactModelsList.add(new ContactModel(name, number, photo));
        }
        phones.close();
    }

    private Bitmap getPhotoFromUri(String photoUri) {
        if (photoUri != null) {
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(mContext.getContentResolver(), Uri.parse(photoUri));
                return bitmap;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
