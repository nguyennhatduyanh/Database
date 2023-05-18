package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference bookRef = db.collection("Books");
    private String TAG = "FireStore";
    private String RECTAG = "FireStore Recycler";
    private FbHelper fbHelper;
        }