package vn.edu.usth2.emailclient.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

import vn.edu.usth2.emailclient.Messages;
import vn.edu.usth2.emailclient.R;
import vn.edu.usth2.emailclient.InboxData.SendAdapter;


public class SentFragment extends Fragment {

    RecyclerView recyclerView;
    DatabaseReference reference;
    SendAdapter sendAdapter;
    ArrayList<Messages> list;
    String useremail;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sent, container, false);
        recyclerView = view.findViewById(R.id.recycle_sent);
        reference = FirebaseDatabase.getInstance().getReference("sent");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));


        list = new ArrayList<>();
        sendAdapter = new SendAdapter(getContext(), list);
        recyclerView.setAdapter(sendAdapter);

        FirebaseUser auth = FirebaseAuth.getInstance().getCurrentUser();

        useremail = auth.getEmail();

        Query query = reference.orderByChild("sender").equalTo(useremail);

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Messages message = dataSnapshot.getValue(Messages.class);
                    list.add(message);
                    Collections.reverse(list);
                }
                sendAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return view;
    }

}