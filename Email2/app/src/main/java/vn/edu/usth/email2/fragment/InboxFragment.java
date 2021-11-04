package vn.edu.usth.email2.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.email2.InboxData.InboxAdapter;
import vn.edu.usth.email2.InboxData.InboxDetail;
import vn.edu.usth.email2.MainActivity;
import vn.edu.usth.email2.R;

public class InboxFragment extends Fragment {

    RecyclerView recyclerView;
    List<InboxDetail> mIbData;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inbox, container, false);
        recyclerView = view.findViewById(R.id.recycle_inbox);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));


        mIbData = new ArrayList<>();

        InboxDetail data = new InboxDetail("Jesus", "Dcm Hung",
                "This is a very looooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooong text", "10:42am");
        mIbData.add(data);

         data = new InboxDetail("Duc", "Dcm Hung",
                "This is a very looooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooong text", "10:42am");
        mIbData.add(data);

         data = new InboxDetail("Ko phai Duc", "Dcm Hung",
                "This is a very looooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooong text", "10:42am");
        mIbData.add(data);

        data = new InboxDetail("Ai do", "Dcm Hung",
                "This is a very looooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooong text", "10:42am");
        mIbData.add(data);

        data = new InboxDetail("Facebook", "Dcm Hung",
                "This is a very looooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooong text", "10:42am");
        mIbData.add(data);

        data = new InboxDetail("Google", "Dcm Hung",
                "This is a very looooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooong text", "10:42am");
        mIbData.add(data);

        data = new InboxDetail("Youtube", "Dcm Hung",
                "This is a very looooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooong text", "10:42am");
        mIbData.add(data);

        data = new InboxDetail("Duong Qua", "Dcm Hung",
                "This is a very looooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooong text", "10:42am");
        mIbData.add(data);

        data = new InboxDetail("Truong Vo Ky", "Dcm Hung",
                "This is a very looooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooong text", "10:42am");
        mIbData.add(data);

        InboxAdapter mInboxAdapter = new InboxAdapter(getActivity(),mIbData);
        recyclerView.setAdapter(mInboxAdapter);
        return view;
    }
}