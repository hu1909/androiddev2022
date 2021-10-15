package vn.edu.usth.email;

import android.location.GnssAntennaInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.widget.ListView;


public class EListFragment extends ListFragment {

    static interface Listener{
        void itemClicked(long id);
    }
    private Listener listener;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String[] senders = new String[Content.contents.length];
        for( int i=0; i<senders.length; i++){
            senders[i] = Content.contents[i].getSender();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                inflater.getContext(), android.R.layout.simple_list_item_1, senders);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        this.listener =(Listener) context;
    }

    @Override
    public void onListItemClick(ListView listView, View itemView, int position, long id ){
        if(listener != null){
            listener.itemClicked(id);
        }
    }

}