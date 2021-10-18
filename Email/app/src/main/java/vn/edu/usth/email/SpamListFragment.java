package vn.edu.usth.email;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.widget.ListView;


public class SpamListFragment extends ListFragment {

    static interface Listener{
        void itemClicked(long id);
    }
    private Listener listener;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String[] spammers = new String[Spamcontent.spamcontents.length];
        for( int i=0; i<spammers.length; i++){
            spammers[i] = Spamcontent.spamcontents[i].getSpammer();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                inflater.getContext(), android.R.layout.simple_list_item_1, spammers);
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