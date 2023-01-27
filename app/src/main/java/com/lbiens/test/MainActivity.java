package com.lbiens.test;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class MainActivity extends AppCompatActivity {

   Button btn_add, btn_add_fragment, btn_exit;
   RecyclerView mRecycler;
   FirebaseFirestore mFirestore;
   FirebaseAuth mAuth;
   SearchView search_view;
   Query query;

   @SuppressLint("NotifyDataSetChanged")
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      mFirestore = FirebaseFirestore.getInstance();
      mAuth = FirebaseAuth.getInstance();
      search_view = findViewById(R.id.search);

      btn_add = findViewById(R.id.btn_add);
      btn_add_fragment = findViewById(R.id.btn_add_fragment);
      btn_exit = findViewById(R.id.btn_close);

      btn_exit.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            mAuth.signOut();
            finish();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
         }
      });

      setUpRecyclerView();
   }

   @SuppressLint("NotifyDataSetChanged")
   private void setUpRecyclerView() {
      mRecycler = findViewById(R.id.recyclerViewSingle);
      mRecycler.setLayoutManager(new LinearLayoutManager(this));
   }
}
